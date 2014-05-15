package mvc.exam3;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class ZipCommand implements ICommand {
	DBConnectionMgr pool=null;
	private Connection con ;
	private ResultSet rs;
	private DataSource ds;
	private PreparedStatement stmt;
	private String sql;
	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String dong = req.getParameter("dong");
		Vector v = new Vector();
		try{
			pool=DBConnectionMgr.getInstance();
			con = pool.getConnection();
			String sql="select *from tblzip where dong like'%"+dong+"%'";
			stmt=con.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()){
				ZipDto zip = new ZipDto();
				zip.setZipcode(rs.getString("zipcode"));
				zip.setSido(rs.getString("sido"));
				zip.setDong(rs.getString("dong"));
				zip.setGugun(rs.getString("gugun"));
				zip.setBunji(rs.getString("bunji"));
				
				v.add(zip);
			}
		}
		catch(Exception err){
			System.out.println("zipCommand"+err);
		}
		finally{
			pool.freeConnection(con,stmt,rs);
		}
		System.out.println(v.size());
		req.setAttribute("zip", v);
		return "/exam3/zipSearch.jsp";
	}

}
