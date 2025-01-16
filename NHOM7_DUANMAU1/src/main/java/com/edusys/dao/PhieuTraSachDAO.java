/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;

import com.edusys.entity.PhieuTraSach;
import com.edusys.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author THANH VINH
 */
public class PhieuTraSachDAO extends EduSysDAO<PhieuTraSach, String> {
    String INSERT_SQL = "INSERT INTO PhieuTraSach(Mapt, Mapm, Ngaytra, Trangthai) VALUES(?,?,?,?)";
    String UPDATE_SQL = "UPDATE PhieuTraSach SET Mapm = ?, Ngaytra = ?, Trangthai = ? WHERE Mapt = ?";
    String DELETE_SQL = "DELETE FROM PhieuTraSach WHERE Mapt =?";
    String SELECT_ALL_SQL ="SELECT * FROM PhieuTraSach";
    String SELECT_BY_ID_SQL = "SELECT * FROM PhieuTraSach WHERE Mapt = ?"; 
    
    @Override
    public void insert(PhieuTraSach entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMapt(), entity.getMapm(), entity.getNgaytra(), entity.getTrangthai());
    }

    @Override
    public void update(PhieuTraSach entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getMapm(), entity.getNgaytra(), entity.getTrangthai(), entity.getMapt());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL,id);
    }

    @Override
    public List<PhieuTraSach> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public PhieuTraSach selectById(String id) {
        List<PhieuTraSach> list = this.selectBySQL(SELECT_BY_ID_SQL, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<PhieuTraSach> selectBySQL(String sql, Object... args) {
        List<PhieuTraSach> list = new ArrayList<PhieuTraSach>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.query(sql, args);
                while(rs.next()){
                    PhieuTraSach pts = readFromResultSet(rs);
                    list.add(pts);
                }
                
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    private PhieuTraSach readFromResultSet(ResultSet rs) throws SQLException {
        PhieuTraSach pts = new PhieuTraSach();
        pts.setMapt(rs.getString("Mapt"));
        pts.setMapm(rs.getString("Mapm"));
        pts.setNgaytra(rs.getDate("Ngaytra"));
        pts.setTrangthai(rs.getString("Trangthai"));
        return pts;
    }
    private List<Object[]> getListOfArray(String sql,String[] cols,Object...args){
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = JdbcHelper.query(sql, args);
            while(rs.next()){
                Object[] vals = new Object[cols.length];
                for(int i = 0;i<cols.length;i++){
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<Object[]> getBangSachTra(){
        String sql = "select PhieuTraSach.Mapt,PhieuTraSach.Mapm,Ngaytra,PhieuTraSach.Trangthai,Phiphat\n" +
                    "from PhieuTraSach join PhieuMuonSach on PhieuTraSach.Mapm=PhieuMuonSach.Mapm\n" +
                    "	join PhieuPhat on PhieuTraSach.Mapt=PhieuPhat.Mapt";
        String[] cols ={"Mapt","Mapm","Ngaytra","Trangthai","Phiphat"};
        return this.getListOfArray(sql, cols);
    }
}
