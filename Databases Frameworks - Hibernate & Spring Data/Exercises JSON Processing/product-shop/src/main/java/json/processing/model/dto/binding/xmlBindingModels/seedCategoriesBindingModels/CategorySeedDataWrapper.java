package json.processing.model.dto.binding.xmlBindingModels.seedCategoriesBindingModels;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategorySeedDataWrapper {

    @XmlElement(name = "category")
    List<CategorySeedDataDto> categories;

    public CategorySeedDataWrapper() {
    }

    public List<CategorySeedDataDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategorySeedDataDto> categories) {
        this.categories = categories;
    }
}
