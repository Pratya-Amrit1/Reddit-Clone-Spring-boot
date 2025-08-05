package com.programming.pratya.springredditclone.mapper;

import com.programming.pratya.springredditclone.dto.PostRequest;
import com.programming.pratya.springredditclone.dto.PostResponse;
import com.programming.pratya.springredditclone.model.Post;
import com.programming.pratya.springredditclone.model.Subreddit;
import com.programming.pratya.springredditclone.model.User;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-17T20:20:25+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.45.0.v20260128-0750, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class PostMapperImpl extends PostMapper {

    @Override
    public Post map(PostRequest postRequest, Subreddit subreddit, User user) {
        if ( postRequest == null && subreddit == null && user == null ) {
            return null;
        }

        Post.PostBuilder post = Post.builder();

        if ( postRequest != null ) {
            post.description( postRequest.getDescription() );
            post.postId( postRequest.getPostId() );
            post.postName( postRequest.getPostName() );
            post.url( postRequest.getUrl() );
        }
        post.subreddit( subreddit );
        post.user( user );
        post.createdDate( java.time.Instant.now() );
        post.voteCount( 0 );

        return post.build();
    }

    @Override
    public PostResponse mapToDto(Post post) {
        if ( post == null ) {
            return null;
        }

        PostResponse postResponse = new PostResponse();

        postResponse.setId( post.getPostId() );
        postResponse.setSubredditName( postSubredditName( post ) );
        postResponse.setUserName( postUserUsername( post ) );
        postResponse.setDescription( post.getDescription() );
        postResponse.setPostName( post.getPostName() );
        postResponse.setUrl( post.getUrl() );
        postResponse.setVoteCount( post.getVoteCount() );

        postResponse.setCommentCount( commentCount(post) );
        postResponse.setDuration( getDuration(post) );
        postResponse.setUpVote( isPostUpVoted(post) );
        postResponse.setDownVote( isPostDownVoted(post) );

        return postResponse;
    }

    private String postSubredditName(Post post) {
        if ( post == null ) {
            return null;
        }
        Subreddit subreddit = post.getSubreddit();
        if ( subreddit == null ) {
            return null;
        }
        String name = subreddit.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String postUserUsername(Post post) {
        if ( post == null ) {
            return null;
        }
        User user = post.getUser();
        if ( user == null ) {
            return null;
        }
        String username = user.getUsername();
        if ( username == null ) {
            return null;
        }
        return username;
    }
}
