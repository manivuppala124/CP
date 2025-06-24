/*A chat application stores each message with:
    • user ID (String)
    • message content (String)
    • timestamp (Instant)

Write a program that:
    1. Counts how many messages each user has sent.
    2. Determines each user’s last-seen time (the most recent timestamp).
    3. Sorts all users by:
         a. last-seen timestamp, newest first
         b. then by message count, highest first
    4. Prints the top three users by this combined ordering.
    
    
Expected Output:
----------------
Top 3 active users: [bob, alice, carol] */
import java.time.Instant;
import java.util.*;
import java.util.stream.*;

public class TopActiveUsers {
    // Domain class
    static class Message {
        private final String userId;
        private final String content;
        private final Instant timestamp;

        public Message(String userId, String content, Instant timestamp) {
            this.userId = userId;
            this.content = content;
            this.timestamp = timestamp;
        }

        public String getUserId() {
            return userId;
        }

        public Instant getTimestamp() {
            return timestamp;
        }
    }

    // Helper class to hold user stats
    static class UserStats {
        String userId;
        long messageCount;
        Instant lastSeen;

        UserStats(String userId, long messageCount, Instant lastSeen) {
            this.userId = userId;
            this.messageCount = messageCount;
            this.lastSeen = lastSeen;
        }

        public String getUserId() {
            return userId;
        }

        public long getMessageCount() {
            return messageCount;
        }

        public Instant getLastSeen() {
            return lastSeen;
        }
    }

    public static void main(String[] args) {
        Instant now = Instant.now();
        List<Message> messages = List.of(
            new Message("alice", "Hi there!",          now),
            new Message("bob",   "Hello!",             now.plusSeconds(5)),
            new Message("alice", "How are you?",       now.plusSeconds(10)),
            new Message("carol", "Good morning",       Instant.parse("2025-06-17T09:30:00Z")),
            new Message("bob",   "I'm fine.",          Instant.parse("2022-06-17T09:31:00Z")),
            new Message("dave",  "Hey!",               now.plusSeconds(15)),
            new Message("alice", "Let's meet up",      Instant.parse("2024-06-17T09:32:30Z")),
            new Message("bob",   "Sure!",              now.plusSeconds(20))
        );

        // Step 1 & 2: Group by userId and compute message count & last seen
        Map<String, List<Message>> grouped = messages.stream()
            .collect(Collectors.groupingBy(Message::getUserId));

        List<UserStats> stats = grouped.entrySet().stream()
            .map(entry -> {
                String user = entry.getKey();
                List<Message> msgs = entry.getValue();
                long count = msgs.size();
                Instant lastSeen = msgs.stream()
                                       .map(Message::getTimestamp)
                                       .max(Comparator.naturalOrder())
                                       .orElse(Instant.MIN);
                return new UserStats(user, count, lastSeen);
            }).collect(Collectors.toList());

        // Step 3: Sort by lastSeen (desc), then message count (desc)
        List<String> top3 = stats.stream()
            .sorted(Comparator
                .comparing(UserStats::getLastSeen).reversed()
                .thenComparing(UserStats::getMessageCount, Comparator.reverseOrder()))
            .limit(3)
            .map(UserStats::getUserId)
            .collect(Collectors.toList());

        System.out.println("Top 3 active users: " + top3);
    }
}
