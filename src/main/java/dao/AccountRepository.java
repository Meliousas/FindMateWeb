package dao;

import dao.mappers.IMapResultIntoEntity;
import dao.uow.IUnitOfWork;
import domain.model.Account;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class AccountRepository extends RepositoryBase<Account> implements IAccountRepository {

    public AccountRepository(Connection connection, IMapResultIntoEntity<Account> mapper, IUnitOfWork uow){
        super(connection, mapper, uow);
    }

    protected String tableName(){
        return "account";
    }

    protected String createTableSql() {
        return "CREATE TABLE account("
            + "id bigint GENERATED BY DEFAULT AS IDENTITY,"
            + "userName VARCHAR(10),"
            + "userPassword VARCHAR(10),"
            + "userEmail VARCHAR(20),"
            + "profileId INT, "
                + "FOREIGN KEY (profileId) REFERENCES profile(id)"
            + ")";}

    protected String insertSql() {
        return "INSERT INTO account(userName,userPassword,userEmail,profileId) VALUES(?,?,?,?)";}

    protected String deleteSql() {
        return "DELETE FROM account WHERE id = ?";}

    protected String updateSql()  {
        return "UPDATE account set userName=?, userPassword=?, userEmail=?, profileId=? WHERE id=?";}

    protected String selectByIdSql()  {
        return "SELECT * FROM account WHERE id=?";}

    protected String selectAllSql()  {
        return "SELECT * FROM account";}

    protected void setupInsert(Account entity) throws SQLException{
        insert.setString(1, entity.getUserName());
        insert.setString(2, entity.getUserPassword());
        insert.setString(3, entity.getUserEmail());
        insert.setInt(4, entity.getProfileId());
    }

    protected void setupUpdate(Account entity) throws SQLException{
        update.setString(1, entity.getUserName());
        update.setString(2, entity.getUserPassword());
        update.setString(3, entity.getUserEmail());
        update.setInt(4, entity.getProfileId());
    }

    public List<Account> withUserName(String userName) {
        // TODO Auto-generated method stub
        return null;
    }

}