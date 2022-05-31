package acme.features.inventor.chimpum;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import acme.entities.Chimpum;
import acme.entities.Item;
import acme.entities.SystemConfiguration;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;

public interface InventorChimpumRepository extends AbstractRepository{
	
	@Query("Select i from Inventor i where i.userAccount.id = :id")
	Inventor findInventorByUserAccountId(int id);
	
	@Query("Select c from Chimpum c where c.item.inventor.id = :id")
	List<Chimpum> findAllChimpumsByInventorId(int id);

	@Query("Select c from Chimpum c where c.id = :id")
	Chimpum findChimpumById(int id);
	
	@Query("Select c from Chimpum c where c.code = :code")
	Chimpum findChimpumByCode(String code);
	
	@Query("Select i from Item i where i.published = :published and i.tipo = acme.entities.TipoDeItem.TOOL and i.inventor.id = :id")
	List<Item> allToolsByInventorId(Boolean published, int id);
	@Query("Select c.item from Chimpum c where c.item.published = :published and c.item.tipo = acme.entities.TipoDeItem.TOOL and c.item.inventor.id = :id")
	List<Item> allToolsWithChimpumByInventorId(Boolean published, int id);

	
	@Query("Select i from Item i where i.id = :id")
	Item findItemById(int id);
	
	@Query("select sc from SystemConfiguration sc")
	SystemConfiguration findSystemConfiguration();
	
}
