package prepareWithGpt;

import java.util.Arrays;

public class D1 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int max = getMax(arr);
        System.out.println("Max element is:-" + max);
    }

    private static int getMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i:arr){
            if(i>max){
                max = i;
            }
        }
        if (max > Integer.MIN_VALUE){
            return max;
        } else {
            return -1;
        }
    }

    private static int getMax1(int[] arr) {
        return Arrays.stream(arr).max().orElse(-1);
    }


    /**
     * Design Problem:- Design a url shortner.
     * Solution:-
     * FR- Design a url shortner.
     * NFR- It should handle 10000 requests per day.
     *
     * Design:-
     * 1. Input has to be a long url, then system will provide a short URL generated,
     * which will be stored in DB with one to one mapping for the long url.
     * 2 services will be created. First service will cater long url and will check
     * if a short url is already stored in DB, if yes then it will be returned,
     * otherwise a new short url will be created, stored in DB and will be returned.
     *
     * Second service will take short URL as input and will check the long URL for which
     * its already mapped in DB. And same will be returned.
     *
     * Users will always see short URLs wherever shared, and long URL is for system to be
     * used to actually redirect to a resource.
     * This conversion in between is only for interface purpose for URLs to provide convenience
     * to users and to make content lookwise normal.
     *
     * Now to actually create short URL different strategies can be used:-
     * 1. Hashing technique
     * 2. can convert to hexagonal or some other representation of the url.
     *
     * Will use redis for the cache to provide quick response for frequently accessed urls
     * This will reduce DB load.
     * Will use kubernetes to automatically load balance and auto scale because url shortening
     * is a kind of service which is mostly used in batch may be. just a guess. So a batch service can
     * also be included.
     *
     * We have to handle 10000 req per day, that means 5 requests per minute. Which is really less
     * for todays systems. So redis o cassandra will be sufficient for handling the database storage part.
     *
     *
     * Judge:-
     *
     * ✅ What You Did Really Well
     * Aspect	Feedback
     * Thought structure	You separated FR/NFR, design, caching, scaling thinking 🔥
     * Services Separation	You correctly split into two services: Create and Retrieve Short URL ✅
     * Cache Awareness	Smart thinking: Redis cache for frequent lookups ✅
     * Storage Thinking	Good thinking about DB load and choosing Redis / Cassandra ✅
     * Scale estimation	You correctly calculated 10000 req/day = 5–10 req/min — very low load ✅
     * K8s and Scaling	Good awareness that this can be auto-scaled based on traffic ✅
     * User Experience Awareness	You mentioned why short URLs matter — very mature system thinking ✅
     * Hashing Strategies Mentioned	Hashing + Hex representations noted — perfect for Day 1 ✅
     * ✅ ✅ You are already thinking at an experienced backend engineer level.
     *
     * 📋 Minor Things to Polish (later, when aiming Staff storytelling)
     * Improvement Area	Suggestion
     * Be a little more structured	Example: First clearly write APIs → Then Components → Then Data Model → Then Cache/Scaling
     * DB choice	Mention briefly why Redis/Cassandra depending on use case: Redis = Fast cache (volatile), Cassandra = Long term storage (distributed DB)
     * URL Collision Handling	When using hashing, mention briefly how you will handle collisions (generate a new hash / retry, etc.)
     * Expiry of Short URLs	Later you can mention (optional) TTL — auto-expiry for temporary short URLs
     * API Response Examples	Optional: You can later show rough JSON input/output examples to show API contract clarity
     * 📜 Improved View (Only Later, for Staff Interview)
     * When you prepare later for full mock interviews, you'd slightly polish your storytelling like:
     *
     * ✅ Functional Requirements (FRs)
     * Accept a long URL and return a shortened version.
     *
     * Redirect a short URL to the original long URL.
     *
     * ✅ Non-Functional Requirements (NFRs)
     * Handle 10K requests/day (very low — no sharding needed initially).
     *
     * Low latency (<100ms) for redirection.
     *
     * High availability.
     *
     * Basic monitoring and alerting.
     *
     * ✅ APIs
     * API	Method	Description
     * /shorten	POST	Accepts a long URL, returns a short URL.
     * /expand/{shortUrl}	GET	Expands short URL back to original long URL.
     * ✅ Data Model
     * Field	Type
     * shortUrl	String (primary key)
     * longUrl	String
     * createdAt	Timestamp
     * expiryDate	(Optional) Timestamp
     * ✅ Components
     * API Gateway (rate limiting, auth if needed)
     *
     * URL Shortener Service
     *
     * Cache (Redis for fast lookups)
     *
     * DB (Cassandra for high availability or RDBMS if very small scale)
     *
     * Monitoring (Prometheus, Grafana)
     *
     * ✅ Scaling/Optimization Thoughts
     * Caching top URLs in Redis.
     *
     * Using Base62 encoding for short URL generation.
     *
     * Handling hash collision by appending a retry token.
     *
     * Kubernetes horizontal auto-scaling based on CPU/latency.
     *
     */
}
