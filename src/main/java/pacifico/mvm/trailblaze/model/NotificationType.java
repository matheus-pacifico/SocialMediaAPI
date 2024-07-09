package pacifico.mvm.trailblaze.model;

public enum NotificationType {
	ACCEPTED_FOLLOW_REQUEST("accepted your follow request."),
	COMMENT("commented:"),
	COMMENT_LIKE("liked your comment:"),
	FOLLOW_REQUEST("sent you a follow request."),
	NEW_FOLLOWER("started following you."),
	POST_LIKE("liked your post."),
	PLATFORM_NOTIFICATION(""),
	OTHER("");

	final String defaultMessage;

	NotificationType(String defaultMessage) {
		this.defaultMessage = defaultMessage;
	}

}
