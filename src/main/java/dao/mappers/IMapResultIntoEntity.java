package dao.mappers;

import domain.model.IHaveId;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Mela on 2016-12-05.
 */
public interface IMapResultIntoEntity <TEntity extends IHaveId> {

    public TEntity map(ResultSet rs) throws SQLException;
}
