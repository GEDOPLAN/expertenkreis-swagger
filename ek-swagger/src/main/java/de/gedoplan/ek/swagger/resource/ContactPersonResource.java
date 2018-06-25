package de.gedoplan.ek.swagger.resource;

import de.gedoplan.ek.swagger.model.ContactPerson;
import de.gedoplan.ek.swagger.resource.security.JWTAuthed;
import de.gedoplan.ek.swagger.service.ContactPersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiKeyAuthDefinition;
import io.swagger.annotations.ApiKeyAuthDefinition.ApiKeyLocation;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.SecurityDefinition;
import io.swagger.annotations.SwaggerDefinition;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dominik Mathmann, GEDOPLAN
 */
@Path("cperson")
@Api(value = "ContactPerson")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@SwaggerDefinition(
        securityDefinition = @SecurityDefinition(
                apiKeyAuthDefinitions = {
                    @ApiKeyAuthDefinition(key = "jwt", name = "Authorization", in = ApiKeyLocation.HEADER)
                }
        )
)
public class ContactPersonResource {

    @Inject
    private ContactPersonService contactPersonService;

    @GET
    @Path("undocumented")
    public List<ContactPerson> getPersons() {
        return contactPersonService.getContactPersons();
    }

    @GET
    @ApiOperation(value = "List of all contactpersons")
    @ApiResponses({
        @ApiResponse(code = 200, message = "all fine", responseContainer = "List", response = ContactPerson.class)
        ,
        @ApiResponse(code = 404, message = "no result", response = Void.class)
    })
    public Response getContactPersons() {
        final List<ContactPerson> persons = contactPersonService.getContactPersons();
        if (persons.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(persons).build();
        }
    }

    @GET
    @Path("{id}")
    @ApiOperation(value = "Resource to get the contact person given by the id")
    public ContactPerson getContactPerson(@ApiParam(value = "contactperson id") @PathParam("id") Integer id) {
        ContactPerson person = this.contactPersonService.getContactPerson(id);
        if (person != null) {
            return person;
        } else {
            Response.ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
            builder.entity("Person not found");
            Response response = builder.build();
            throw new WebApplicationException(response);
        }
    }

    @POST
    @JWTAuthed
    @ApiOperation(value = "Save a Contact Person", authorizations = {
        @Authorization(value = "jwt")})
    public ContactPerson addContactPerson(ContactPerson p) {
        ContactPerson person = this.contactPersonService.addContactPerson(p);
        return person;
    }
}
