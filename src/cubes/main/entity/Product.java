 package cubes.main.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Size;

@Entity
@Table
public class Product {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	@Size(min=3, max=20, message="min 3, max 20 characters")
	private String name;
	
	@Column
	@Size(min=10, max=120, message="min 10, max 120 characters")
	private String description;
	
	@Column
	@Size(max=120, message="max 120 characters")
	private String image;
	
	@Column
	private double price;
	
	@Valid
	@JoinColumn(name="idRecipes")
	@OneToOne(cascade = CascadeType.ALL)
	private Recipes recipe;
	
	@JoinColumn(name="idCategory")
	@ManyToOne(cascade ={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private Category category;
	
	@ManyToMany(cascade ={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name="product_tag", joinColumns = @JoinColumn(name="id_product"), inverseJoinColumns = @JoinColumn(name = "id_tag"))
	private List<Tag> tags;
	@Column
	private boolean isOnMainPage;
	@Column
	private boolean isOnMenu;
	
	
	public Product() {
		
	}

	
	public Product(int id, String name, String description, String image, double price, Recipes recipe,
			Category category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.image = image;
		this.price = price;
		this.recipe = recipe;
		this.category = category;
	}



	public Product(int id, String name, String description, String image, double price, Recipes recipe,
			Category category, List<Tag> tags) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.image = image;
		this.price = price;
		this.recipe = recipe;
		this.category = category;
		this.tags = tags;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Recipes getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipes recipe) {
		this.recipe = recipe;
	}
	
	
	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public List<Tag> getTags() {
		return tags;
	}


	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	

	public boolean getIsOnMainPage() {
		return isOnMainPage;
	}


	public void setIsOnMainPage(boolean isOnMainPage) {
		this.isOnMainPage = isOnMainPage;
	}
 
	

	public boolean getIsOnMenu() {
		return isOnMenu;
	}


	public void setIsOnMenu(boolean isOnMenu) {
		this.isOnMenu = isOnMenu;
	}


	@Override
	public String toString() {
		
		return "("+id+")-" + name;
	}
	

}
