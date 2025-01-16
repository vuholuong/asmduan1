/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;
import com.edusys.entity.PhieuLamThe;
import com.edusys.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author THANH VINH
 */
public class PhieuLamTheDAO extends EduSysDAO<PhieuLamThe, String>{
    String INSERT_SQL = "INSERT INTO PhieuLamThe(Maplt, Manv, Loaiphieu, Phithe, Ngaylapphieu) VALUES(?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE PhieuLamThe SET Manv = ? , Loaiphieu = ?, Phithe = ?, Ngaylapphieu = ? WHERE Maplt =?";
    String DELETE_SQL = "DELETE FROM PhieuLamThe WHERE Maplt =?";
    String SELECT_ALL_SQL ="SELECT * FROM PhieuLamThe";
    String SELECT_BY_ID_SQL = "SELECT * FROM PhieuLamThe WHERE Maplt = ?"; 

    @Override
    public void insert(PhieuLamThe entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaplt(), entity.getManv(), entity.getLoaiphieu(), entity.getPhithe(), entity.getNgaylapphieu());
    }
    
    java.sql.Date sqlDate;
    public Date convertDate(java.util.Date date){
        sqlDate = new java.sql.Date(date.getTime());
        return sqlDate;
    }
    
    @Override
    public void update(PhieuLamThe entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getManv(), entity.getLoaiphieu(), entity.getPhithe(), entity.getNgaylapphieu(), entity.getMaplt());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL,id);
    }

    @Override
    public List<PhieuLamThe> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public PhieuLamThe selectById(String id) {
        List<PhieuLamThe> list = this.selectBySQL(SELECT_BY_ID_SQL, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<PhieuLamThe> selectBySQL(String sql, Object... args) {
        List<PhieuLamThe> list = new ArrayList<PhieuLamThe>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.query(sql, args);
                while(rs.next()){
                    PhieuLamThe plt = readFromResultSet(rs);
                    list.add(plt);
                }
                
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    private PhieuLamThe readFromResultSet(ResultSet rs) throws SQLException {
        PhieuLamThe plt = new PhieuLamThe();
        plt.setMaplt(rs.getString("Maplt"));
        plt.setManv(rs.getString("Manv"));
        plt.setLoaiphieu(rs.getBoolean("Loaiphieu"));
        plt.setPhithe(rs.getFloat("Phithe"));
        plt.setNgaylapphieu(rs.getDate("Ngaylapphieu"));
        return plt;
    }
}
