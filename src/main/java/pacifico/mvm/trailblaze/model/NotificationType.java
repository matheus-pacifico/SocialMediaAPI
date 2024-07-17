package pacifico.mvm.trailblaze.model;

public enum NotificationType {
	ACCEPTED_FOLLOW_REQUEST("accepted your follow request."),
	COMMENT("commented:"),
	COMMENT_REPLY("replied to your comment:"),
	FOLLOW_REQUEST("sent you a follow request."),
	MENTION("mentioned you in"),
	NEW_FOLLOWER("started following you."),
	POST_LIKE("liked your post."),
	PLACE_RATING("has rated a place."),
	PLATFORM_NOTIFICATION(""),
	OTHER("");

	final String defaultMessage;

	NotificationType(String defaultMessage) {
		this.defaultMessage = defaultMessage;
	}

}
