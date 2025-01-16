/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;

import com.edusys.entity.PhieuMuonSach;
import com.edusys.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author THANH VINH
 */
public class PhieuMuonSachDAO extends EduSysDAO<PhieuMuonSach, String>{
    String INSERT_SQL = "INSERT INTO PhieuMuonSach(Mapm, Masach, Manv, Madg, Trangthai, Ngaymuon, Soluong) VALUES(?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE PhieuMuonSach SET Tensach = ?, Maloai = ?, Manxb = ?, Ngayxuatban = ?, Tacgia = ?, Mota = ?, Soluong = ?, Vitri = ? WHERE Masach = ?";
    String DELETE_SQL = "DELETE FROM PhieuMuonSach WHERE Mapm =?";
    String SELECT_ALL_SQL ="SELECT * FROM PhieuMuonSach";
    String SELECT_BY_ID_SQL = "SELECT * FROM PhieuMuonSach WHERE Mapm = ?"; 
    
    @Override
    public void insert(PhieuMuonSach entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMapm(), entity.getManv(), entity.getMadg(), entity.getTrangthai(), entity.getNgaymuon(),entity.getSoluong());
    }

    @Override
    public void update(PhieuMuonSach entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getManv(), entity.getMadg(), entity.getTrangthai(), entity.getNgaymuon(),entity.getSoluong(), entity.getMapm());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL,id);
    }

    @Override
    public List<PhieuMuonSach> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public PhieuMuonSach selectById(String id) {
        List<PhieuMuonSach> list = this.selectBySQL(SELECT_BY_ID_SQL, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<PhieuMuonSach> selectBySQL(String sql, Object... args) {
        List<PhieuMuonSach> list = new ArrayList<PhieuMuonSach>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.query(sql, args);
                while(rs.next()){
                    PhieuMuonSach pms = readFromResultSet(rs);
                    list.add(pms);
                }
                
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    private PhieuMuonSach readFromResultSet(ResultSet rs) throws SQLException {
        PhieuMuonSach pms = new PhieuMuonSach();
        pms.setManv(rs.getString("Manv"));
        pms.setMadg(rs.getString("Madg"));
        pms.setTrangthai(rs.getString("Trangthai"));
        pms.setNgaymuon(rs.getDate("Ngaymuon"));
        pms.setSoluong(rs.getInt("Soluong"));
        return pms;
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
    public List<Object[]> getBangSachMuon(){
        String sql = "select ChiTietPhieuMuon.Mapm,ChiTietPhieuMuon.Masach,Madg,Ngaymuon,Trangthai\n" +
                    "from ChiTietPhieuMuon join PhieuMuonSach on PhieuMuonSach.Mapm=ChiTietPhieuMuon.Mapm\n" +
                    "			Join Sach on ChiTietPhieuMuon.Masach=Sach.Masach";
        String[] cols ={"Mapm","Masach","Madg","NgayMuon","Trangthai"};
        return this.getListOfArray(sql, cols);
    }
}
