package pl.avntrka.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import pl.avntrka.model.Product;
import pl.avntrka.model.User;
import pl.avntrka.util.ConnectorProvider;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDAOImpl implements ProductDAO {

    private static final String CREATE_PRODUCT =
            "INSERT INTO avtrka.product(name, description, category, user_id, date, pris, brand, conditio, picture_name) " +
                    "VALUES(:name, :description, :category, :user_id, :date, :pris, :brand, :conditio, :picture_name)";
    private static final String READ_ALL_PRODUCTS =
            "SELECT *"
    + " FROM avtrka.product LEFT JOIN user ON product.user_id = user.user_id";

    private static final String READ_PRODUCT_BY_ADD =
            "SELECT * FROM avtrka.product WHERE username = :username, description= :description, user= :user, pris= :pris";

    private static final String ADD_CONDITION_BRAND =
            "UPDATE avtrka.product " +
                    "SET brand=:brand) where product_id= :id";



    private static final String READ_PRODUCT_BY_ID =
            "SELECT * FROM avtrka.product WHERE product_id = :id";




    private NamedParameterJdbcTemplate template;

    public ProductDAOImpl() {
        template = new NamedParameterJdbcTemplate(ConnectorProvider.getDataSource());
    }

    @Override
    public Product create(Product product) {
        Product resultProduct = new Product(product);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        Map<String, Object> paramMap=new HashMap<String, Object>();
        paramMap.put("name", product.getName());
        paramMap.put("description", product.getDescription());
        paramMap.put("category", product.getCategory());
        paramMap.put("brand", product.getBrand());
        paramMap.put("pris", product.getPris());
        paramMap.put("conditio", product.getCondition());
        paramMap.put("user_id", product.getUser().getId());
        paramMap.put("date", product.getTimestamp());
        paramMap.put("picture_name", product.getPictureName());

        SqlParameterSource parameterSource = new MapSqlParameterSource(paramMap);
        int update = template.update(CREATE_PRODUCT, parameterSource, keyHolder);

        if (update > 0) {
           resultProduct.setId(keyHolder.getKey().longValue());
        }

        long prodID=resultProduct.getId();
        SqlParameterSource paramSource = new MapSqlParameterSource("id", prodID);

        return resultProduct;
    }


    @Override
    public Product read(Long primaryKey) {
        return null;
    }

    @Override
    public boolean update(Product updateObject) {
        return false;
    }

    @Override
    public boolean delete(Long key) {
        return false;
    }

    @Override
    public List<Product> getAll() {
        List<Product> products=template.query(READ_ALL_PRODUCTS, new ProductRowMapper());
        return products;
    }

    @Override
    public Product getProductById(long primaryKey) {
        Product resultProduct = null;
        SqlParameterSource paramSource = new MapSqlParameterSource("id", primaryKey);
        resultProduct = template.queryForObject(READ_PRODUCT_BY_ID, paramSource, new ProductRowMapper());
        return resultProduct;
    }




    private class ProductRowMapper implements RowMapper<Product> {

        @Override
        public Product mapRow(ResultSet resultSet, int row) throws SQLException {
            Product product = new Product();
            product.setId(resultSet.getLong("product_id"));
            product.setName(resultSet.getString("name"));
            product.setTimestamp(resultSet.getTimestamp("date"));
            product.setBrand(resultSet.getString("brand"));
            product.setCondition(resultSet.getString("conditio"));
            product.setPris(resultSet.getString("pris"));
            product.setCategory(resultSet.getString("category"));
            product.setDescription(resultSet.getString("description"));
            product.setPictureName(resultSet.getString("picture_name"));
            User user = new User();
            user.setId(resultSet.getLong("user_id"));
            user.setUsername(resultSet.getString("username"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            product.setUser(user);
            return product;
        }
    }

}
