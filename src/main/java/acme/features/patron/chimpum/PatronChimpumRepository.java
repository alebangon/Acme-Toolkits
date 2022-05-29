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
	
	@Query("Select c from Chimpum c where c.patron.id = :id")
	List<Chimpum> findChimpumsByPatronId(int id);

	@Query("Select c from Chimpum c where c.id = :id")
	Chimpum findChimpumById(int id);
	
	@Query("Select i from Item i")
	List<Item> allItems();

	@Query("Select i from Item i where i.id = :id")
	Item findItemById(int id);
	
	@Query("select sc from SystemConfiguration sc")
	SystemConfiguration findSystemConfiguration();
	
}
