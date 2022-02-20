package com.icemelon404.community.social.infra;

import com.icemelon404.community.social.domain.dto.FollowCount;
import com.icemelon404.community.social.domain.follow.count.FollowCountModifier;
import com.icemelon404.community.social.domain.follow.count.FollowCountReader;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

@RequiredArgsConstructor
public class JdbcCountRepository implements FollowCountModifier, FollowCountReader {

    private final JdbcTemplate template;

    @Override
    public void modifyFollowCount(long userId, int amount) {
        template.update("UPDATE follow_count SET follow= follow + ? WHERE id= ?", amount, userId);
    }

    @Override
    public void modifyFollowerCount(long userId, int amount) {
        template.update("UPDATE follow_count SET follower= follower + ? WHERE id= ?", amount, userId);
    }

    @Override
    public FollowCount getFollowCount(long userId) {
        try {
            return template.queryForObject("SELECT * FROM follow_count WHERE id= ?",
                    (ps, row) -> new FollowCount(ps.getInt("follower"), ps.getInt("follow")),
                    userId);
        } catch (EmptyResultDataAccessException exception) {
            return new FollowCount(0, 0);
        }
    }
}
