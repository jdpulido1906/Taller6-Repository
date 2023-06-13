package co.edu.sena.project_2687365.model.repository;
import co.edu.sena.project_2687365.connection_test.ConnectionPool;
import co.edu.sena.project_2687365.model.beans.Category;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImpl implements co.edu.sena.project_2687365.model.repository.Repository<Category> {
    private String sql = null;

    @Override
    public List<Category> listAllObj() throws SQLException {
        sql = "select c.category_id, c.category_name" +
                "from category_tbl c";

        List<Category> categorys = new ArrayList<>();
        try (Connection conn = ConnectionPool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Category c = createObj(rs);
                categorys.add(c);
            }//While
        }// try
        return categorys;
    }

    @Override
    public Category byIdObj(Integer id) throws SQLException {
        sql = "select c.category_name " +
                "from category_tbl c where c.category_id=?";
        Category category = null;
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    category = createObj(rs);
                    }
                }
            }
            return category;
        }

        @Override
        public Integer saveObj (Category category) throws SQLException {
            int rowsAffected = 0;
            if (category.getCategory_id() != null && category.getCategory_id() > 0) {
                sql = "update category_tbl set category_name=?" +
                        " where category_id=?";

            } else {
                sql = "insert into category_tbl(category_name)" +
                        "values(upper(?))";
            }
            try (Connection conn = ConnectionPool.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, category.getCategory_name());
                if (category.getCategory_id() != null) {
                    ps.setInt(2, category.getCategory_id());
                }
                rowsAffected = ps.executeUpdate();
            }
            return rowsAffected;
        }

        @Override
        public void deleteObj (Integer id) throws SQLException {
            sql= "delete from category_tbl where category_id=?";
            try(Connection conn = ConnectionPool.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)){
                ps.setInt(1,id);
                ps.executeUpdate();
            }//try
        }

        @Override
        public Category createObj (ResultSet rs) throws SQLException {
            Category category = new Category();
            category.setCategory_id(rs.getInt("category_id"));
            category.setCategory_name(rs.getString("category_name"));
            return category;
        }
    }
