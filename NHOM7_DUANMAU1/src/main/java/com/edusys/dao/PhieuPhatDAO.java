package com.edusys.dao;


import com.edusys.dao.EduSysDAO;
import com.edusys.entity.PhieuPhat;
import com.edusys.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author THANH VINH
 */
public class PhieuPhatDAO extends EduSysDAO<PhieuPhat, String> {
    String INSERT_SQL = "INSERT INTO PhieuPhat(Mapp, Mapt, Noidung, Phiphat) VALUES(?,?,?,?)";
    String UPDATE_SQL = "UPDATE PhieuPhat SET Mapt = ?, Noidung = ?, Phiphat = ? WHERE Mapp = ?";
    String DELETE_SQL = "DELETE FROM PhieuPhat WHERE Mapp =?";
    String SELECT_ALL_SQL ="SELECT * FROM PhieuPhat";
    String SELECT_BY_ID_SQL = "SELECT * FROM PhieuPhat WHERE Mapt = ?"; 
    
    @Override
    public void insert(PhieuPhat entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMapp(), entity.getMapt(), entity.getNoidung(), entity.getPhiphat());
    }

    @Override
    public void update(PhieuPhat entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getMapt(), entity.getNoidung(), entity.getPhiphat(), entity.getMapp());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL,id);
    }

    @Override
    public List<PhieuPhat> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public PhieuPhat selectById(String id) {
        List<PhieuPhat> list = this.selectBySQL(SELECT_BY_ID_SQL, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<PhieuPhat> selectBySQL(String sql, Object... args) {
        List<PhieuPhat> list = new ArrayList<PhieuPhat>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.query(sql, args);
                while(rs.next()){
                    PhieuPhat pp = readFromResultSet(rs);
                    list.add(pp);
                }
                
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    private PhieuPhat readFromResultSet(ResultSet rs) throws SQLException {
        PhieuPhat pp = new PhieuPhat();
        pp.setPhiphat(rs.getFloat("Phiphat"));
        return pp;
    }
}
