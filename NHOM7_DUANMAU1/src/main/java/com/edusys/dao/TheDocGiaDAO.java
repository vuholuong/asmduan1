/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;

import com.edusys.entity.TheDocGia;
import com.edusys.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author THANH VINH
 */
public class TheDocGiaDAO extends EduSysDAO<TheDocGia, String>{
    String INSERT_SQL = "INSERT INTO TheDG(Madg, Maplt, Hoten, Sdt, DiaChi, Ngaydangki, Ngayhethan, hinh) VALUES(?,?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE TheDG SET Maplt = ?, Hoten = ?, Sdt = ?, Diachi = ?, Ngaydangki = ?, Ngayhethan = ?, Hinh = ? WHERE Madg =?";
    String DELETE_SQL = "DELETE FROM TheDG WHERE Madg =?";
    String SELECT_ALL_SQL ="SELECT * FROM TheDG";
    String SELECT_BY_ID_SQL = "SELECT * FROM TheDG WHERE Madg = ?"; 
    
    @Override
    public void insert(TheDocGia entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMadg(), entity.getMaplt(), entity.getHoten(), entity.getSdt(), entity.getDiachi(), entity.getNgaydangki(), entity.getNgayhethan());
    }

    @Override
    public void update(TheDocGia entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getMaplt(), entity.getHoten(), entity.getSdt(), entity.getDiachi(), entity.getNgaydangki(), entity.getNgayhethan(), entity.getMadg());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL,id);
    }

    @Override
    public List<TheDocGia> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public TheDocGia selectById(String id) {
        List<TheDocGia> list = this.selectBySQL(SELECT_BY_ID_SQL, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<TheDocGia> selectBySQL(String sql, Object... args) {
        List<TheDocGia> list = new ArrayList<TheDocGia>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.query(sql, args);
                while(rs.next()){
                    TheDocGia tdg = readFromResultSet(rs);
                    list.add(tdg);
                }
                
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    private TheDocGia readFromResultSet(ResultSet rs) throws SQLException {
        TheDocGia tdg = new TheDocGia();
        tdg.setMadg(rs.getString("Madg"));
        tdg.setMaplt(rs.getString("Maplt"));
        tdg.setHoten(rs.getString("Hoten"));
        tdg.setSdt(rs.getString("Sdt"));
        tdg.setDiachi(rs.getString("Diachi"));
        tdg.setNgaydangki(rs.getDate("Ngaydangki"));
        tdg.setNgayhethan(rs.getDate("Ngayhethan"));
        return tdg;
    }
}
