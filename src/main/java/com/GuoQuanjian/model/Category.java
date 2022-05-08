package com.GuoQuanjian.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Category {
    private Integer categoryId;
    private String categoryName;
    private String description;
    private boolean active;

    public Category() {
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category(String categoryName, String description, boolean active) {
        this.categoryName = categoryName;
        this.description = description;
        this.active = active;
    }

    public Category(Integer categoryId, String categoryName, String description, boolean active) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
        this.active = active;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                ", active=" + active +
                '}';
    }

    public static List<Category> findAllCateGory(Connection con) throws SQLException {
        String sql = "select * from category";
        List<Category> categoryList = new ArrayList<Category>();
        System.out.println(con);
        PreparedStatement pt = con.prepareStatement(sql);
        ResultSet rs = pt.executeQuery();
        while (rs.next()) {
            Category category = new Category();
            category.setCategoryId(rs.getInt("categoryId"));
            category.setCategoryName(rs.getString("categoryName"));
            category.setDescription(rs.getString("description"));
            categoryList.add(category);
        }
        return categoryList;
    }

    public static String findByCategoryId(Connection con, int categoryId) throws SQLException {
        String sql = "select * from category where categoryId=?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setInt(1, categoryId);
        ResultSet rs = pt.executeQuery();
        String categoryName = null;
        while (rs.next()) {
            Category category = new Category();

            category.setCategoryName(rs.getString("categoryName"));
        }
        return categoryName;
    }


}
