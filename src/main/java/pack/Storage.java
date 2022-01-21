package pack;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;



public class Storage {
	private static String jdbcUrl = null;
	private static String jdbcUser = null;
	private static String jdbcPassword = null;

	public static void init(String jdbcDriver, String jdbcUrl, String jdbcUser,
			String jdbcPassword) throws ClassNotFoundException {
		Class.forName(jdbcDriver);
		Storage.jdbcUrl = jdbcUrl;
		Storage.jdbcUser = jdbcUser;
		Storage.jdbcPassword = jdbcPassword;
	}
	private static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
	}
	

	/// «¿œ–Œ—€ ƒÀﬂ —œ≈÷»¿À‹ÕŒ—“≈…
	
	///œŒ ¿«¿“‹ ¬—≈ —œ≈÷»¿À‹ÕŒ—“»
	public static Collection<Spec> readAllSpec() throws SQLException {
		String sql = "SELECT `id`, `name`, `uzk`, `amount`, `salary`,`costs`"
				+ "FROM `spec` ";
				
		Connection c = null;
		Statement s = null;
		ResultSet r = null;
		try {
			c = getConnection();
			s = c.createStatement();
			r = s.executeQuery(sql);
			Collection<Spec> specList = new ArrayList<>();
			while (r.next()) {
				Spec speci = new Spec();
				speci.setId(r.getInt("id"));
				speci.setName(r.getString("name"));
				speci.setUzk(r.getString("uzk"));
				speci.setAmount(r.getInt("amount"));
				speci.setSalary(r.getInt("salary"));
				specList.add(speci);
			}
			return specList;
		} finally {
			try {				r.close();
			} catch (NullPointerException | SQLException e) {
			}
			try {
				s.close();
			} catch (NullPointerException | SQLException e) {
			}
			try {
				c.close();
			} catch (NullPointerException | SQLException e) {
			}
		}
	}
	
	public static Collection<Spec> sortSpec(String field) throws SQLException {
		String sql = "SELECT `id`, `name`, `uzk`, `amount`, `salary`,`costs` "
				+ "FROM `spec` "
				+ "ORDER BY `"+ field +"` ";
				
		Connection c = null;
		Statement s = null;
		ResultSet r = null;
		try {
			c = getConnection();
			s = c.createStatement();
			r = s.executeQuery(sql);
			Collection<Spec> specList = new ArrayList<>();
			while (r.next()) {
				Spec speci = new Spec();
				speci.setId(r.getInt("id"));
				speci.setName(r.getString("name"));
				speci.setUzk(r.getString("uzk"));
				speci.setAmount(r.getInt("amount"));
				speci.setSalary(r.getInt("salary"));
				specList.add(speci);
			}
			return specList;
		} finally {
			try {				r.close();
			} catch (NullPointerException | SQLException e) {
			}
			try {
				s.close();
			} catch (NullPointerException | SQLException e) {
			}
			try {
				c.close();
			} catch (NullPointerException | SQLException e) {
			}
		}
	}
	
	///”ƒ¿À»“‹ —œ≈÷»¿À‹ÕŒ—“‹
	public static void deleteSpec(Integer id) throws SQLException {
		String sql = "DELETE FROM `spec` " + "WHERE `id` = ?";
		Connection c = null;
		PreparedStatement s = null;
		try {
			c = getConnection();
			s = c.prepareStatement(sql);
			s.setInt(1, id);
			s.executeUpdate();
		} finally {
			try {
				s.close();
			} catch (NullPointerException | SQLException e) {
			}
			try {
				c.close();
			} catch (NullPointerException | SQLException e) {
			}
		}
	}
	///—Œ«ƒ¿“‹ ÕŒ¬”ﬁ —œ≈÷»¿À‹ÕŒ—“‹
	public static void createSpec(Spec spec) throws SQLException {
		String sql = "INSERT INTO `spec` "
				+ "(`name`, `uzk`, `amount`, `salary`) "
				+ "VALUES " + "(?, ?, ?, ?)";
		Connection c = null;
		PreparedStatement s = null;
		try {
			c = getConnection();
			s = c.prepareStatement(sql);
			s.setString(1, spec.getName());
			s.setString(2, spec.getUzk());
			s.setInt(3, spec.getAmount());
			s.setInt(4, spec.getSalary());
			s.executeUpdate();
		} finally {
			try {
				s.close();
			} catch (NullPointerException | SQLException e) {
			}
			try {
				c.close();
			} catch (NullPointerException | SQLException e) {
			}
		}
	}
	///–≈ƒ¿ “»–Œ¬¿“‹ —œ≈÷»¿À‹ÕŒ—“‹
	public static void updateSpec(Spec spec) throws SQLException {
		String sql = "UPDATE `spec` SET "
				+ "`name` = ?, `uzk` = ?, `amount` = ?, `salary` = ? "
				+ "WHERE `id` = ?";
		Connection c = null;
		PreparedStatement s = null;
		try {
			c = getConnection();
			s = c.prepareStatement(sql);
			s.setString(1, spec.getName());
			s.setString(2, spec.getUzk());
			s.setInt(3, spec.getAmount());
			s.setInt(4, spec.getSalary());
			s.setInt(5, spec.getId());
			s.executeUpdate();
		} finally {
            try {
                s.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
		}
	}
	  
	///œŒ ¿…ƒ»
	public static Spec readByIdSpec(Integer id)
			throws SQLException {
		String sql = "SELECT `id`, `name`, `uzk`, `amount`, `salary`,`costs`"
				+ "FROM `spec` " + "WHERE `id` = ?";
		Connection c = null;
		PreparedStatement s = null;
		ResultSet r = null;
		try {
			c = getConnection();
			s = c.prepareStatement(sql);
			s.setInt(1, id);
			r = s.executeQuery();
			Spec speci=null;
			while (r.next()) {
				speci = new Spec();
				speci.setId(r.getInt("id"));
				speci.setName(r.getString("name"));
				speci.setUzk(r.getString("uzk"));
				speci.setAmount(r.getInt("amount"));
				speci.setSalary(r.getInt("salary"));
				
			}
			return speci;
		} finally {
			try {
				r.close();
			} catch (NullPointerException | SQLException e) {
			}
			try {
				s.close();
			} catch (NullPointerException | SQLException e) {
			}
			try {
				c.close();
			} catch (NullPointerException | SQLException e) {
			}
		}
	}
	
	
	/// «¿œ–Œ—€ ƒÀﬂ ¬–¿◊≈…
	public static Collection<Doc> readAllDoc() throws SQLException {
		String sql = "SELECT `id`, `id_spec`, `fio`, `bday`,`hiring`, `number`,`payment`"
				+ "FROM `doc` ";
				
			
		Connection c = null;
		Statement s = null;
		ResultSet r = null;
		try {
			c = getConnection();
			s = c.createStatement();
			r = s.executeQuery(sql);
			Collection<Doc> docList = new ArrayList<>();
			while (r.next()) {
				Doc doctor = new Doc();
				doctor.setId(r.getInt("id"));
				doctor.setSpecId(r.getInt("id_spec"));
				doctor.setFio(r.getString("fio"));
				doctor.setBday(r.getString("bday"));
				doctor.setHiring(r.getString("hiring"));
				doctor.setNumber(r.getInt("number"));
				docList.add(doctor);
			}
			return docList;
		} finally {
			try {				r.close();
			} catch (NullPointerException | SQLException e) {
			}
			try {
				s.close();
			} catch (NullPointerException | SQLException e) {
			}
			try {
				c.close();
			} catch (NullPointerException | SQLException e) {
			}
		}
	}
	
	public static Collection<Doc> readByIdDoc(Integer id)
			throws SQLException {
		String sql = "SELECT `id`, `id_spec`, `fio`, `bday`,`hiring`, `number`,`payment`"
				+ "FROM `doc` " + "WHERE `id_spec` = ?";
		Connection c = null;
		PreparedStatement s = null;
		ResultSet r = null;
		try {
			c = getConnection();
			s = c.prepareStatement(sql);
			s.setInt(1, id);
			r = s.executeQuery();
			Collection<Doc> docList = new ArrayList<>();
			while (r.next()) {
				Doc doctor = new Doc();
				doctor.setId(r.getInt("id"));
				doctor.setSpecId(r.getInt("id_spec"));
				doctor.setFio(r.getString("fio"));
				doctor.setBday(r.getString("bday"));
				doctor.setHiring(r.getString("hiring"));
				doctor.setNumber(r.getInt("number"));
				docList.add(doctor);
			}
			return docList;
		} finally {
			try {
				r.close();
			} catch (NullPointerException | SQLException e) {
			}
			try {
				s.close();
			} catch (NullPointerException | SQLException e) {
			}
			try {
				c.close();
			} catch (NullPointerException | SQLException e) {
			}
		}
	}
	public static Collection<Doc> SortDoc(Integer id, String field)
			throws SQLException {
		String sql = "SELECT `id`, `id_spec`, `fio`, `bday`,`hiring`, `number`,`payment` "
				+ "FROM `doc` " + "WHERE `id_spec` = ? "+ "ORDER BY `"+ field +"` ";;
		Connection c = null;
		PreparedStatement s = null;
		ResultSet r = null;
		try {
			c = getConnection();
			s = c.prepareStatement(sql);
			s.setInt(1, id);
			r = s.executeQuery();
			Collection<Doc> docList = new ArrayList<>();
			while (r.next()) {
				Doc doctor = new Doc();
				doctor.setId(r.getInt("id"));
				doctor.setSpecId(r.getInt("id_spec"));
				doctor.setFio(r.getString("fio"));
				doctor.setBday(r.getString("bday"));
				doctor.setHiring(r.getString("hiring"));
				doctor.setNumber(r.getInt("number"));
				docList.add(doctor);
			}
			return docList;
		} finally {
			try {
				r.close();
			} catch (NullPointerException | SQLException e) {
			}
			try {
				s.close();
			} catch (NullPointerException | SQLException e) {
			}
			try {
				c.close();
			} catch (NullPointerException | SQLException e) {
			}
		}
	}
	
	public static void deleteDoc(Integer id) throws SQLException {
		String sql = "DELETE FROM `doc` " + "WHERE `id` = ?";
		Connection c = null;
		PreparedStatement s = null;
		try {
			c = getConnection();
			s = c.prepareStatement(sql);
			s.setInt(1, id);
			s.executeUpdate();
		} finally {
			try {
				s.close();
			} catch (NullPointerException | SQLException e) {
			}
			try {
				c.close();
			} catch (NullPointerException | SQLException e) {
			}
		}
	}
	public static Doc readByIdDocSingle(Integer id)
			throws SQLException {
		String sql = "SELECT `id`, `id_spec`, `fio`, `bday`,`hiring`, `number`,`payment`"
				+ "FROM `doc` " + "WHERE `id` = ?";
		Connection c = null;
		PreparedStatement s = null;
		ResultSet r = null;
		try {
			c = getConnection();
			s = c.prepareStatement(sql);
			s.setInt(1, id);
			r = s.executeQuery();
			Doc doctor = null;
			if (r.next()) {
				doctor = new Doc();
				doctor.setId(r.getInt("id"));
				doctor.setSpecId(r.getInt("id_spec"));
				doctor.setFio(r.getString("fio"));
				doctor.setBday(r.getString("bday"));
				doctor.setHiring(r.getString("hiring"));
				doctor.setNumber(r.getInt("number"));
			}
			return doctor;
		} finally {
			try {
				r.close();
			} catch (NullPointerException | SQLException e) {
			}
			try {
				s.close();
			} catch (NullPointerException | SQLException e) {
			}
			try {
				c.close();
			} catch (NullPointerException | SQLException e) {
			}
		}
	}
	public static void createDoc(Doc doctor)
			throws SQLException {
		String sql = "INSERT INTO `doc` "
				+ "(`id_spec`, `fio`, `bday`,`hiring`, `number`) "
				+ "VALUES " + "( ?, ?, ?, ?, ?)";
		Connection c = null;
		PreparedStatement s = null;
		try {
			c = getConnection();
			s = c.prepareStatement(sql);
			s.setInt(1, doctor.getSpecId());
			s.setString(2, doctor.getFio());
			s.setString(3, doctor.getBday());
			s.setString(4, doctor.getHiring());
			s.setInt(5, doctor.getNumber());
			
			s.executeUpdate();
		} finally {
			try {
				s.close();
			} catch (NullPointerException | SQLException e) {
			}
			try {
				c.close();
			} catch (NullPointerException | SQLException e) {
			}
		}
	}
	public static void updateDoc(Doc doctor)
			throws SQLException {
		String sql = "UPDATE `lab5`.`doc` SET "
				+ "`id_spec` = ?, `fio` = ?, `bday` = ?, `hiring` = ?,`number` = ? "
				+ "WHERE `id` = ?";
		Connection c = null;
		PreparedStatement s = null;
		try {
			c = getConnection();
			s = c.prepareStatement(sql);
			s.setInt(1, doctor.getSpecId());
			s.setString(2, doctor.getFio());
			s.setString(3, doctor.getBday());
			s.setString(4, doctor.getHiring());
			s.setInt(5, doctor.getNumber());
			s.setInt(6, doctor.getId());
			s.executeUpdate();
		} finally {
			try {
				s.close();
			} catch (NullPointerException | SQLException e) {
			}
			try {
				c.close();
			} catch (NullPointerException | SQLException e) {
			}
		}
	}

	public static Integer getCountAmount(Integer id) throws SQLException {
		String sql = "SELECT COUNT(*) AS `amount` " 
				+ "FROM `doc` "
				+ "WHERE `id_spec` = ? ";
		Connection c = null;
		PreparedStatement s = null;
		ResultSet r = null;
		try {
			c = getConnection();
			s = c.prepareStatement(sql);
			s.setInt(1, id);
			r = s.executeQuery();
			if (r.next()) {
				return r.getInt("amount");
			}
			return 0;
		} finally {
			try {
				r.close();
			} catch (NullPointerException | SQLException e) {
			}
			try {
				s.close();
			} catch (NullPointerException | SQLException e) {
			}
			try {
				c.close();
			} catch (NullPointerException | SQLException e) {
			}
		}
	}
//////////////////
/////////////////
	///////////////////USER///////////////
	
	   public static boolean checkUser(User user) throws SQLException {
	        String sql = "SELECT COUNT(*) AS `amount` "
	                   + "FROM `Users` "
	                   + "WHERE `login` = ? AND `password` = ? AND `role` = ?";
	        Connection c = null;
	        PreparedStatement s = null;
	        ResultSet r = null;
	        try {
	            c = getConnection();
	            s = c.prepareStatement(sql);
	            s.setString(1, user.getLogin());
	            s.setString(2, user.getPassword());
	            s.setString(3, user.getRole());
	            r = s.executeQuery();
	            if(r.next()) {
	                return r.getInt("amount") == 1;
	            }
	            return false;
	        } finally {
	            try {
	                r.close();
	            } catch(NullPointerException | SQLException e) {}
	            try {
	                s.close();
	            } catch(NullPointerException | SQLException e) {}
	            try {
	                c.close();
	            } catch(NullPointerException | SQLException e) {}
	        }
	    }

	    public static Collection<User> readUsers() throws SQLException {
	        String sql = "SELECT `id`, `role`, `login`, `password` "
	                   + "FROM `Users`";
	        Connection c = null;
	        Statement s = null;
	        ResultSet r = null;
	        try {
	            c = getConnection();
	            s = c.createStatement();
	            r = s.executeQuery(sql);
	            Collection<User> objects = new ArrayList<>();
	            while(r.next()) {
	                User object = new User();
	                object.setId(r.getInt("id"));
	                object.setRole(r.getString("role"));
	                object.setLogin(r.getString("login"));
	                object.setPassword(r.getString("password"));
	                objects.add(object);
	            }
	            return objects;
	        } finally {
	            try {
	                r.close();
	            } catch(NullPointerException | SQLException e) {}
	            try {
	                s.close();
	            } catch(NullPointerException | SQLException e) {}
	            try {
	                c.close();
	            } catch(NullPointerException | SQLException e) {}
	        }
	    }

	    public static User readByIdUsers(Integer id) throws SQLException {
	        String sql = "SELECT `id`, `role`, `login`, `password` "
	                   + "FROM `Users` "
	                   + "WHERE `id` = ?";
	        Connection c = null;
	        PreparedStatement s = null;
	        ResultSet r = null;
	        try {
	            c = getConnection();
	            s = c.prepareStatement(sql);
	            s.setInt(1, id);
	            r = s.executeQuery();
	            User object = null;
	            if(r.next()) {
	                object = new User();
	                object.setId(id);
	                object.setRole(r.getString("role"));
	                object.setLogin(r.getString("login"));
	                object.setPassword(r.getString("password"));

	            }
	            return object;
	        } finally {
	            try {
	                r.close();
	            } catch(NullPointerException | SQLException e) {}
	            try {
	                s.close();
	            } catch(NullPointerException | SQLException e) {}
	            try {
	                c.close();
	            } catch(NullPointerException | SQLException e) {}
	        }
	    }

	    public static void createUsers(User object) throws SQLException {
	        String sql = "INSERT INTO `Users` "
	                   + "(`role`, `login`, `password`) "
	                   + "VALUES "
	                   + "(?, ?, ?)";
	        Connection c = null;
	        PreparedStatement s = null;
	        try {
	            c = getConnection();
	            s = c.prepareStatement(sql);
	            s.setString(1, object.getRole());
	            s.setString(2, object.getLogin());
	            s.setString(3, object.getPassword());
	            s.executeUpdate();
	        } finally {
	            try {
	                s.close();
	            } catch(NullPointerException | SQLException e) {}
	            try {
	                c.close();
	            } catch(NullPointerException | SQLException e) {}
	        }
	    }

	    public static void updateUsers(User object) throws SQLException {
	        String sql = "UPDATE `Users` SET "
	                   + "`role` = ?, `login` = ?, `password` = ? "
	                   + "WHERE `id` = ?";
	        Connection c = null;
	        PreparedStatement s = null;
	        try {
	            c = getConnection();
	            s = c.prepareStatement(sql);
	            s.setString(1, object.getRole());
	            s.setString(2, object.getLogin());
	            s.setString(3, object.getPassword());
	            s.setInt(4, object.getId());
	            s.executeUpdate();
	        } finally {
	            try {
	                s.close();
	            } catch(NullPointerException | SQLException e) {}
	            try {
	                c.close();
	            } catch(NullPointerException | SQLException e) {}
	        }
	    }

	    public static void deleteUsers(Integer id) throws SQLException {
	        String sql = "DELETE FROM `Users` "
	                   + "WHERE `id` = ?";
	        Connection c = null;
	        PreparedStatement s = null;
	        try {
	            c = getConnection();
	            s = c.prepareStatement(sql);
	            s.setInt(1, id);
	            s.executeUpdate();
	        } finally {
	            try {
	                s.close();
	            } catch(NullPointerException | SQLException e) {}
	            try {
	                c.close();
	            } catch(NullPointerException | SQLException e) {}
	        }
	    }

}
	
