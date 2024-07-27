import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "LinkedPurchaseList")
public @Data class LinkedPurchaseList {
    @EmbeddedId
    private LinkedPurchaseKey id;

    public LinkedPurchaseList() {
    }

    public LinkedPurchaseList(LinkedPurchaseKey id) {
        this.id = id;
    }


}

