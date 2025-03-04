package pacifico.mvm.trailblaze.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(schema = "users", name = "\"user\"")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(columnDefinition = "BIGINT DEFAULT users.u_next_id()", insertable = false, updatable = false)
	private long id;
	
	@Column(length = 30, unique = true, nullable = false)
	private String username;

	@Column(length = 50, nullable = false)
	private String name;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date birthday;
    
	private String photoPath;
	
	@Column(columnDefinition = "BIGINT DEFAULT get_now()", insertable = false, nullable = false, updatable = false)
	private long createdAt;

	@Column(length = 6)
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@JsonIgnoreProperties(value = {"password", "user"}, allowSetters = true)
	@OneToOne(mappedBy = "user", fetch = FetchType.LAZY, optional = false)
	private Credential credential;
	
	@JsonIgnoreProperties(value = {"user"}, allowSetters = true)
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, optional = false)
	private Profile profile;
	
	@JsonIgnoreProperties(value = {"user"}, allowSetters = true)
	@OneToMany(mappedBy = "user")
	private List<Comment> comments;
	
	@JsonIgnoreProperties(value = {"user"}, allowSetters = true)
	@OneToMany(mappedBy = "user")
	private List<Rate> rates;
	
	@JsonIgnoreProperties(value = {"user"}, allowSetters = true)
	@OneToMany(mappedBy = "user")
	private List<ReactionComment> reactionComments = new ArrayList<>();
	
	@JsonIgnoreProperties(ignoreUnknown = true, value = {"id", "followed"})
	@OneToMany(mappedBy = "followed", cascade = CascadeType.REMOVE)
	private List<UserFollows> followers = new ArrayList<>();
	
	@JsonIgnoreProperties(ignoreUnknown = true, value = {"id", "follower"})
	@OneToMany(mappedBy = "follower", cascade = CascadeType.REMOVE)
	private List<UserFollows> followeds = new ArrayList<>();
	
	@JsonIgnoreProperties(ignoreUnknown = true, value = {"id", "requester"})
	@OneToMany(mappedBy = "requester", cascade = CascadeType.REMOVE)
	private List<FollowRequest> sentRequests = new ArrayList<>();
	
	@JsonIgnoreProperties(ignoreUnknown = true, value = {"id", "receiver"})
	@OneToMany(mappedBy = "receiver", cascade = CascadeType.REMOVE)
	private List<FollowRequest> receivedRequests = new ArrayList<>();
	
	@JsonIgnoreProperties(value = {"recipient"}, allowSetters = true)
	@OneToMany(mappedBy = "recipient")
	private List<Notification> notifications = new ArrayList<>();
	
	@JsonIgnoreProperties(value = {"user"}, allowSetters = true)
	@OneToMany(mappedBy = "creator")
	private List<PostList> postLists = new ArrayList<>();
	
	@JsonIgnoreProperties(value = {"user"}, allowSetters = true)
	@OneToMany(mappedBy = "user")
	private List<SavedPost> savedPosts = new ArrayList<>();
	
	@JsonIgnoreProperties(value = {"user"}, allowSetters = true)
	@OneToMany(mappedBy = "creator")
	private List<PlaceList> placeLists = new ArrayList<>();
	
	@JsonIgnoreProperties(value = {"user"}, allowSetters = true)
	@OneToMany(mappedBy = "user")
	private List<SavedPlace> savedPlaces = new ArrayList<>();
	
	@JsonIgnoreProperties(value = {"user"})
	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	private List<PostLike> postLikes;
	
	public User() {
		
	}

	public User(long id, String username, String name, String photoPath, 
			long createdAt, Gender gender, Credential credential) {
		this.id = id;
		this.username = username;
		this.name = name;
		this.photoPath = photoPath;
		this.createdAt = createdAt;
		this.gender = gender;
		this.credential = credential;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Credential getCredential() {
		return credential;
	}

	public void setCredential(Credential credential) {
		this.credential = credential;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}


	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public List<Rate> getRates() {
		return rates;
	}

	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}

	public List<ReactionComment> getReactionComments() {
		return reactionComments;
	}

	public void setReactionComments(List<ReactionComment> reactionComments) {
		this.reactionComments = reactionComments;
	}

	public List<UserFollows> getFollowers() {
		return followers;
	}

	public void setFollowers(List<UserFollows> followers) {
		this.followers = followers;
	}

	public List<UserFollows> getFolloweds() {
		return followeds;
	}

	public void setFolloweds(List<UserFollows> followeds) {
		this.followeds = followeds;
	}

	public List<FollowRequest> getSentRequests() {
		return sentRequests;
	}

	public void setSentRequests(List<FollowRequest> sentRequests) {
		this.sentRequests = sentRequests;
	}

	public List<FollowRequest> getReceivedRequests() {
		return receivedRequests;
	}

	public void setReceivedRequests(List<FollowRequest> receivedRequests) {
		this.receivedRequests = receivedRequests;
	}

	public List<PostList> getPostLists() {
		return postLists;
	}

	public void setPostLists(List<PostList> postLists) {
		this.postLists = postLists;
	}

	public List<SavedPost> getSavedPosts() {
		return savedPosts;
	}

	public void setSavedPosts(List<SavedPost> savedPosts) {
		this.savedPosts = savedPosts;
	}

	public List<PlaceList> getPlaceLists() {
		return placeLists;
	}

	public void setPlaceLists(List<PlaceList> placeLists) {
		this.placeLists = placeLists;
	}

	public List<SavedPlace> getSavedPlaces() {
		return savedPlaces;
	}

	public void setSavedPlaces(List<SavedPlace> savedPlaces) {
		this.savedPlaces = savedPlaces;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
}
