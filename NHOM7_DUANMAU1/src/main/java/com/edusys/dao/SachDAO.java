/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;

import com.edusys.entity.Sach;
import com.edusys.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author THANH VINH
 */
public class SachDAO extends EduSysDAO<Sach, String>{
    String INSERT_SQL = "INSERT INTO Sach(Masach, Tensach, Maloai, Manxb, Ngayxuatban, Tacgia, Mota, Soluong, Vitri) VALUES(?,?,?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE Sach SET Tensach = ?, Maloai = ?, Manxb = ?, Ngayxuatban = ?, Tacgia = ?, Mota = ?, Soluong = ?, Vitri = ? WHERE Masach = ?";
    String DELETE_SQL = "DELETE FROM Sach WHERE Masach =?";
    String SELECT_ALL_SQL ="SELECT * FROM Sach";
    String SELECT_BY_ID_SQL = "SELECT * FROM Sach WHERE Masach = ?"; 
    
    @Override
    public void insert(Sach entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMasach(), entity.getTensach(), entity.getMaloai(), entity.getManxb(), entity.getNgayxuatban(), entity.getTacgia(), entity.getMota(),entity.getSoluong(),entity.getVitri());
    }

    @Override
    public void update(Sach entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getTensach(), entity.getMaloai(), entity.getManxb(), entity.getNgayxuatban(), entity.getTacgia(), entity.getMota(),entity.getSoluong(),entity.getVitri(), entity.getMasach());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL,id);
    }

    @Override
    public List<Sach> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public Sach selectById(String id) {
        List<Sach> list = this.selectBySQL(SELECT_BY_ID_SQL, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<Sach> selectBySQL(String sql, Object... args) {
        List<Sach> list = new ArrayList<Sach>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.query(sql, args);
                while(rs.next()){
                    Sach s = readFromResultSet(rs);
                    list.add(s);
                }
                
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    private Sach readFromResultSet(ResultSet rs) throws SQLException {
        Sach s = new Sach();
        s.setMasach(rs.getString("Masach"));
        s.setTensach(rs.getString("Tensach"));
        s.setMaloai(rs.getString("Maloai"));
        s.setManxb(rs.getString("Manxb"));
        s.setNgayxuatban(rs.getDate("Ngayxuatban"));
        s.setTacgia(rs.getString("Tacgia"));
        s.setMota(rs.getString("Mota"));
        s.setSoluong(rs.getInt("Soluong"));
        return s;
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
    public List<Object[]> getBangSach(){
        String sql = "select Masach,Tensach,Tenloai,Tacgia,Tennxb,Mota\n" +
                    "from Sach join LoaiSach on Sach.Maloai=LoaiSach.Maloai\n" +
                    "		Join NhaXB on Sach.Manxb=NhaXB.Manxb";
        String[] cols ={"Masach","Tensach","Tenloai","Tacgia","Tennxb","Mota"};
        return this.getListOfArray(sql, cols);
    }
}
