package test.performance.backend.post;

import java.util.List;
import java.util.Map;

public class ShowPostsResponse {

    private List<PostResponse> posts;

    public ShowPostsResponse(List<PostResponse> posts) {
        this.posts = posts;
    }

    public static ShowPostsResponse from(List<Post> posts) {
        return new ShowPostsResponse(posts.stream().map(PostResponse::from).toList());
    }

    public static ShowPostsResponse from(Map<Post, Long> posts) {
        return new ShowPostsResponse(posts.entrySet().stream()
                .map((entry) -> PostResponse.of(entry.getKey(), entry.getValue()))
                .toList());
    }

    public List<PostResponse> getPosts() {
        return posts;
    }
}
