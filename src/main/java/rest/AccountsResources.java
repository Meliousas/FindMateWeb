package rest;

import domain.model.Account;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import rest.dto.AccountDto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/accounts")
@Stateless
public class AccountsResources {
	
	Mapper mapper = new DozerBeanMapper();
	
    @PersistenceContext
    EntityManager entityManager;
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
    	List<AccountDto> result = new ArrayList<AccountDto>();
    	for(Account c: entityManager.createNamedQuery("account.all",Account.class).getResultList()){
        	result.add(mapper.map(c, AccountDto.class));
        }
        return Response.ok(new GenericEntity<List<AccountDto>>(result){}).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
    	Account result = entityManager.createNamedQuery("account.id", Account.class)
                .setParameter("id", id)
                .getSingleResult();
        if (result == null) {
            return Response.status(404).build();
        }
        return Response.ok(result).build();
    }

}
