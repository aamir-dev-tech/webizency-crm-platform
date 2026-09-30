CREATE TABLE team_members (
    team_id CHAR(36) NOT NULL,
    user_id CHAR(36) NOT NULL,
    joined_at TIMESTAMP(6) NOT NULL,

    PRIMARY KEY (team_id, user_id),

    INDEX idx_team_members_user (user_id)
);