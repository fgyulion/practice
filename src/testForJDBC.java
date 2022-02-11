import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

public class testForJDBC {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        Class.forName("com.uxsino.uxdb.Driver");
        Connection connection = DriverManager.getConnection("jdbc:uxdb://192.168.0.110:5432/uxdb?defaultRowFetchSize=3", "uxsmo", "123456");

        PreparedStatement preparedStatement = connection.prepareStatement("select * from t1");
        ResultSet rs = preparedStatement.executeQuery();
//        while (rs.next()) {
//            InputStream is = rs.getBinaryStream(1);
//            byte[] buffer = new byte[10];
//            int size = 0;
//            while ((size = is.read(buffer)) != -1) {
//                System.out.println(new String(buffer, 0, size));
//            }
//        }
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
    }
}