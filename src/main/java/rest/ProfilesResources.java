package rest;

import domain.model.Profile;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import rest.dto.ProfileDto;

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

@Path("/profiles")
@Stateless
public class ProfilesResources {
	
	Mapper mapper = new DozerBeanMapper();
	
    @PersistenceContext
    EntityManager entityManager;
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
    	List<ProfileDto> result = new ArrayList<ProfileDto>();
    	for(Profile s: entityManager.createNamedQuery("profile.all",Profile.class).getResultList()){
        	result.add(mapper.map(s, ProfileDto.class));
        }
        return Response.ok(new GenericEntity<List<ProfileDto>>(result){}).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
    	Profile result = entityManager.createNamedQuery("profile.id", Profile.class)
                .setParameter("id", id)
                .getSingleResult();
        if (result == null) {
            return Response.status(404).build();
        }
        return Response.ok(result).build();
    }

}
