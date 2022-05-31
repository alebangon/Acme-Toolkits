package acme.features.patron.chimpum;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import acme.entities.Chimpum;
import acme.entities.Item;
import acme.entities.SystemConfiguration;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Patron;

public interface PatronChimpumRepository extends AbstractRepository{
	
	@Query("Select p from Patron p where p.userAccount.id = :id")
	Patron findPatronByUserAccountId(int id);
	
	@Query("Select c from Chimpum c")
	List<Chimpum> findAllChimpums();

	@Query("Select c from Chimpum c where c.id = :id")
	Chimpum findChimpumById(int id);
	
	@Query("Select c from Chimpum c where c.code = :code")
	Chimpum findChimpumByCode(String code);
	
	@Query("Select i from Item i where i.published = :published and i.tipo = acme.entities.TipoDeItem.TOOL")
	List<Item> allTools(Boolean published);

	@Query("Select i from Item i where i.id = :id")
	Item findItemById(int id);
	
	@Query("select sc from SystemConfiguration sc")
	SystemConfiguration findSystemConfiguration();
	@Query("Select c from Chimpum c where c.patron.id = :id")
	List<Chimpum> findAllChimpumsByPatronId(int id);
	
	
	
}
