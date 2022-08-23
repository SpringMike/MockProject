package intern.sapo.be.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalTime;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;


	@Column(name = "username", nullable = false, length = 200)
	private String username;

	@Column(name = "password", nullable = false, length = 500)
	private String password;

	@CreatedDate
	@Column(name = "create_at", nullable = false)
	private Timestamp createAt;

	@LastModifiedDate
	@Column(name = "update_at")
	private Timestamp updateAt;

	@Column(name = "is_delete", nullable = false)
	private Boolean isDelete = false;


	@ManyToMany
//    @JsonBackReference
	@JoinTable(name = "accounts_roles", joinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Set<Role> roles = new HashSet<>();

	//    @JsonBackReference
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	private List<Employee> employee;

}