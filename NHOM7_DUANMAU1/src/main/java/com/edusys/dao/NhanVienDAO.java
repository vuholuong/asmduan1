/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.dao;

import com.edusys.entity.NhanVien;
import com.edusys.utils.JdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;




public class NhanVienDAO extends EduSysDAO<NhanVien, String> {
    String INSERT_SQL = "INSERT INTO NhanVien(Manv, Hoten, Sdt, Email, Diachi, Chucvu, Matkhau) VALUES(?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE NhanVien SET Hoten = ? , Sdt = ?, Email = ?, Diachi = ?,Chucvu = ?, Matkhau = ? WHERE Manv =?";
    String DELETE_SQL = "DELETE FROM NhanVien WHERE Manv =?";
    String SELECT_ALL_SQL ="SELECT * FROM NhanVien";
    String SELECT_BY_ID_SQL = "SELECT * FROM NhanVien WHERE Manv = ?"; 
    
    @Override
    public void insert(NhanVien entity) {
        JdbcHelper.update(INSERT_SQL, entity.getManv(), entity.getHoten(), entity.getSdt(), entity.getEmail(), entity.getDiachi(), entity.getChucvu(), entity.getMatkhau());
    }

    @Override
    public void update(NhanVien entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getHoten(), entity.getSdt(), entity.getEmail(), entity.getDiachi(), entity.getChucvu(), entity.getMatkhau(), entity.getManv());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL,id);
    }

    @Override
    public List<NhanVien> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public NhanVien selectById(String id) {
        List<NhanVien> list = this.selectBySQL(SELECT_BY_ID_SQL, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<NhanVien> selectBySQL(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<NhanVien>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.query(sql, args);
                while(rs.next()){
                    NhanVien nv = readFromResultSet(rs);
                    list.add(nv);
                }
                
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
        
    }
    
    private NhanVien readFromResultSet(ResultSet rs) throws SQLException {
        NhanVien nv = new NhanVien();
        nv.setManv(rs.getString("Manv"));
        nv.setHoten(rs.getString("Hoten"));
        nv.setSdt(rs.getString("Sdt"));
        nv.setEmail(rs.getString("Email"));
        nv.setDiachi(rs.getString("Diachi"));
        nv.setChucvu(rs.getBoolean("Chucvu"));
        nv.setMatkhau(rs.getString("Matkhau"));
        return nv;
    }
}
