/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;

import com.edusys.entity.ChiTietPhieuMuon;
import com.edusys.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author THANH VINH
 */
public class ChiTietPhieuMuonDAO extends EduSysDAO<ChiTietPhieuMuon, String> {
    String INSERT_SQL = "INSERT INTO ChiTietPhieuMuon(Mapm, Masach, Ngaytra) VALUES(?,?,?)";
    String UPDATE_SQL = "UPDATE ChiTietPhieuMuon SET Masach = ?, Ngaytra = ?, WHERE Mapm = ?";
    String DELETE_SQL = "DELETE FROM ChiTietPhieuMuon WHERE Mapm =?";
    String SELECT_ALL_SQL ="SELECT * FROM ChiTietPhieuMuon";
    String SELECT_BY_ID_SQL = "SELECT * FROM ChiTietPhieuMuon WHERE Mapm = ?"; 
    
    @Override
    public void insert(ChiTietPhieuMuon entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMapm(), entity.getMasach(), entity.getNgaytra());
    }

    @Override
    public void update(ChiTietPhieuMuon entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getMasach(), entity.getNgaytra(),entity.getMasach());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL,id);
    }

    @Override
    public List<ChiTietPhieuMuon> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public ChiTietPhieuMuon selectById(String id) {
        List<ChiTietPhieuMuon> list = this.selectBySQL(SELECT_BY_ID_SQL, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<ChiTietPhieuMuon> selectBySQL(String sql, Object... args) {
        List<ChiTietPhieuMuon> list = new ArrayList<ChiTietPhieuMuon>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.query(sql, args);
                while(rs.next()){
                    ChiTietPhieuMuon ctpm = readFromResultSet(rs);
                    list.add(ctpm);
                }
                
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    private ChiTietPhieuMuon readFromResultSet(ResultSet rs) throws SQLException {
        ChiTietPhieuMuon ctpm = new ChiTietPhieuMuon();
        ctpm.setMapm(rs.getString("Mapm"));
        ctpm.setMasach(rs.getString("Masach"));
        ctpm.setNgaytra(rs.getDate("Ngaytra"));
        return ctpm;
    }
}
