package spittr.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spittr.Spittle;


@Repository
public class SpittleRepositoryJdbc implements SpittleRepository{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Spittle> findSpittles(long max, int count) {
		return jdbcTemplate.query(
		        "select id, message, created_at, latitude, longitude" +
		        " from Spittle" +
		        " order by created_at desc limit 20",
		        new SpittleRowMapper());
	}

	@Override
	public Spittle findOne(long spittleId) {
		return jdbcTemplate.queryForObject(
		        "select id, message, created_at, latitude, longitude" +
		        " from Spittle" +
		        " where id = ?",
		        new SpittleRowMapper(), spittleId);
	}
	
	
	private static class SpittleRowMapper implements RowMapper<Spittle> {
		public Spittle mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Spittle(
				rs.getLong("id"),
				rs.getString("message"), 
				rs.getDate("created_at"), 
				rs.getDouble("longitude"), 
				rs.getDouble("latitude"));
			}
	}
	
}
