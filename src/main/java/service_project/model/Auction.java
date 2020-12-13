package service_project.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "AUCTION")
@Getter
@Setter
public class Auction {

    @Id
    @GeneratedValue
    @Column(name = "AUCTION_ID")
    private Long id;

    @Column(length = 100)
    private String title;

    @Column(length = 300)
    private String description;

    @Lob
    @Column
    private byte[] picture;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User user;

    @Column(name =  "MINIMUM_AMOUNT", precision = 8, scale = 2)
    private BigDecimal minimumAmount;

    @Column(name =  "BUY_NOW_AMOUNT", precision = 8, scale = 2)
    private BigDecimal buyNowAmount;

    @Column(name = "IS_PROMOTED", nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isPromoted;

    @Column(length = 200)
    private String location;

    @Column
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Column
    @Temporal(TemporalType.DATE)
    private Date endDate;

}
