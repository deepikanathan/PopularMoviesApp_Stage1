package com.nanodegree.projects.popularmovies.popular_movies_stage_one.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Model class for Movie object with properties such as Title, Rating, ReleaseDate and Poster
 */
public class Movie implements Parcelable
{

    private String originalTitle;
    private String posterThumbnail;
    private String synopsisOverview;
    private String userRating;
    private String releaseDate;

    public Movie(){}

    /**
     * OriginalTitle getter
     * @return originalTitle as String
     */
    public String getOriginalTitle()
    {
        return originalTitle;
    }

    /**
     * OriginalTitle setter
     * @param originalTitle as String
     */
    public void setOriginalTitle(String originalTitle)
    {
        this.originalTitle = originalTitle;
    }

    /**
     * posterThumbnail getter
     * @return posterThumbnail URL as String
     */
    public String getPoster_thumbnail()
    {

        String TMDB_POSTER_BASE_URL = "https://image.tmdb.org/t/p/w185";
        return TMDB_POSTER_BASE_URL + posterThumbnail;
    }

    /**
     * posterThumbnail setter
     * @param poster_thumbnail URL as String
     */
    public void setPoster_thumbnail(String poster_thumbnail)
    {
        this.posterThumbnail = poster_thumbnail;
    }

    /**
     * Synopsis/Overview getter
     * @return synopsisOverview as String
     */
    public String getSynopsisOverview()
    {
        return synopsisOverview;
    }

    /**
     * Synopsis/Overview setter
     * @param synopsisOverview as String
     */
    public void setSynopsisOverview(String synopsisOverview)
    {
        this.synopsisOverview = synopsisOverview;
    }

    /**
     * Release Date getter
     * @return releaseDate as String
     */
    public String getReleaseDate()
    {
        return releaseDate;
    }

    /**
     * Release Date setter
     * @param releaseDate as String
     */
    public void setReleaseDate(String releaseDate)
    {
        this.releaseDate = releaseDate;
    }

    /**
     * User Rating getter
     * @return userRating as String
     */
    public String getUserRating()
    {
        return userRating;
    }

    /**
     * User Rating setter
     * @param userRating as String
     */
    public void setUserRating(String userRating)
    {
        this.userRating = userRating;
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    /**
     * Write Movie properties to Parcel.
     * @param parcel Parcel object
     * @param i flags
     */
    @Override
    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(originalTitle);
        parcel.writeString(posterThumbnail);
        parcel.writeString(synopsisOverview);
        parcel.writeString(userRating);
        parcel.writeString(releaseDate);
    }

    /**
     * Get Movie properties from Parcel object
     * @param parcel Parcel
     */
    private Movie(Parcel parcel)
    {
        originalTitle = parcel.readString();
        posterThumbnail = parcel.readString();
        synopsisOverview = parcel.readString();
        userRating = parcel.readString();
        releaseDate = parcel.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>()
    {
        public Movie createFromParcel(Parcel source)
        {
            return new Movie(source);
        }

        public Movie[] newArray(int size)
        {
            return new Movie[size];
        }
    };
}

//  datae from "http://api.themoviedb.org/3/movie/popular?api_key=f700b19d1af0889265b81cb218235275"
//{
//        "page":1,
//        "total_results":19816,
//        "total_pages":991,
//        "results":[
//        {
//        "vote_count":135,
//        "id":399579,
//        "video":false,
//        "vote_average":6.4,
//        "title":"Alita: Battle Angel",
//        "popularity":349.136,
//        "poster_path":"\/xRWht48C2V8XNfzvPehyClOvDni.jpg",
//        "original_language":"en",
//        "original_title":"Alita: Battle Angel",
//        "genre_ids":[
//        28,
//        878,
//        53,
//        10749
//        ],
//        "backdrop_path":"\/8RKBHHRqOMOLh5qW3sS6TSFTd8h.jpg",
//        "adult":false,
//        "overview":"When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
//        "release_date":"2019-01-31"
//        },
//        {
//        "vote_count":1100,
//        "id":480530,
//        "video":false,
//        "vote_average":6.6,
//        "title":"Creed II",
//        "popularity":277.522,
//        "poster_path":"\/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg",
//        "original_language":"en",
//        "original_title":"Creed II",
//        "genre_ids":[
//        18,
//        28
//        ],
//        "backdrop_path":"\/8yqLPNwNCtpOPc3XkOlkSMnghzw.jpg",
//        "adult":false,
//        "overview":"Follows Adonis Creed's life inside and outside of the ring as he deals with new found fame, issues with his family, and his continuing quest to become a champion.",
//        "release_date":"2018-11-21"
//        },
//        {
//        "vote_count":82,
//        "id":505954,
//        "video":false,
//        "vote_average":4.6,
//        "title":"T-34",
//        "popularity":271.169,
//        "poster_path":"\/wNJF8R5QE6nBT7DQoKk8t6YD1MM.jpg",
//        "original_language":"ru",
//        "original_title":"T-34",
//        "genre_ids":[
//        10752,
//        18,
//        12,
//        28
//        ],
//        "backdrop_path":"\/59qyrVGLLtrcuFtJGdixzn7H4OI.jpg",
//        "adult":false,
//        "overview":"1941 - WWii. the second lieutenant Nikolai ivushkin, commander of a t-34, engages in an unequal battle against the tank ace Klaus Jager in a battle near moscow. His mission is more of a suicide - to destroy a dozen german tanks, all by himself. that said, luck does favour the bold. He wins the battle, barely survives, but loses his tank and lands himself in captivity for three long years... there was little to no chance for ivushkin and Jager to meet again, but the war knows how to throw a curve ball.in the spring of 1944, the Wehrmacht commands Jager to take charge of the ohrdruf  re range and turn it into a training center for elite german armored forces, using the latest t-34 as a running target. this is how Jager and ivushkin cross paths again. Jager o ers ivushkin to become the commander of a legendary tank and pick his crew from fellow camp prisoners. Nothing goes according to plan, though, when ivushkin uses exercises for a daring and carefully planned escape.",
//        "release_date":"2018-12-27"
//        },
//        {
//        "vote_count":1311,
//        "id":450465,
//        "video":false,
//        "vote_average":6.7,
//        "title":"Glass",
//        "popularity":207.205,
//        "poster_path":"\/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
//        "original_language":"en",
//        "original_title":"Glass",
//        "genre_ids":[
//        53,
//        9648,
//        18,
//        14
//        ],
//        "backdrop_path":"\/lvjscO8wmpEbIfOEZi92Je8Ktlg.jpg",
//        "adult":false,
//        "overview":"In a series of escalating encounters, security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
//        "release_date":"2019-01-16"
//        },
//        {
//        "vote_count":1161,
//        "id":404368,
//        "video":false,
//        "vote_average":7.4,
//        "title":"Ralph Breaks the Internet",
//        "popularity":181.285,
//        "poster_path":"\/lDroo0e4Pr33c1Y4LWr7f4IE8f2.jpg",
//        "original_language":"en",
//        "original_title":"Ralph Breaks the Internet",
//        "genre_ids":[
//        10751,
//        16,
//        35,
//        14
//        ],
//        "backdrop_path":"\/88poTBTafMXaz73vYi3c74g0y2k.jpg",
//        "adult":false,
//        "overview":"Six years after the events of \"Wreck-It Ralph,\" Ralph and Vanellope, now friends, discover a wi-fi router in their arcade, leading them into a new adventure.",
//        "release_date":"2018-11-20"
//        },
//        {
//        "vote_count":4884,
//        "id":424694,
//        "video":false,
//        "vote_average":8.2,
//        "title":"Bohemian Rhapsody",
//        "popularity":170.104,
//        "poster_path":"\/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
//        "original_language":"en",
//        "original_title":"Bohemian Rhapsody",
//        "genre_ids":[
//        18,
//        10402
//        ],
//        "backdrop_path":"\/93xA62uLd5CwMOAs37eQ7vPc1iV.jpg",
//        "adult":false,
//        "overview":"Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
//        "release_date":"2018-10-24"
//        },
//        {
//        "vote_count":21,
//        "id":438650,
//        "video":false,
//        "vote_average":6.3,
//        "title":"Cold Pursuit",
//        "popularity":144.109,
//        "poster_path":"\/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
//        "original_language":"en",
//        "original_title":"Cold Pursuit",
//        "genre_ids":[
//        53,
//        28,
//        18
//        ],
//        "backdrop_path":"\/aiM3XxYE2JvW1vJ4AC6cI1RjAoT.jpg",
//        "adult":false,
//        "overview":"Nels Coxman's quiet life comes crashing down when his beloved son dies under mysterious circumstances. His search for the truth soon becomes a quest for revenge as he seeks coldblooded justice against a drug lord and his inner circle.",
//        "release_date":"2019-02-07"
//        },
//        {
//        "vote_count":830,
//        "id":375262,
//        "video":false,
//        "vote_average":7.7,
//        "title":"The Favourite",
//        "popularity":139.806,
//        "poster_path":"\/4hgPWxYeGWtTEx9BPhUo99wj77z.jpg",
//        "original_language":"en",
//        "original_title":"The Favourite",
//        "genre_ids":[
//        18,
//        36,
//        35
//        ],
//        "backdrop_path":"\/ph5fElfh4U7O3jwhFljxz2LDp1l.jpg",
//        "adult":false,
//        "overview":"In 18th century England, the close relationship between Queen Anne and Sarah Churchill is threatened by the arrival of Sarah's cousin, Abigail Hill, resulting in a bitter rivalry between the two cousins to be the Queen's favourite.",
//        "release_date":"2018-11-20"
//        },
//        {
//        "vote_count":476,
//        "id":438799,
//        "video":false,
//        "vote_average":6.9,
//        "title":"Overlord",
//        "popularity":139.713,
//        "poster_path":"\/l76Rgp32z2UxjULApxGXAPpYdAP.jpg",
//        "original_language":"en",
//        "original_title":"Overlord",
//        "genre_ids":[
//        27,
//        10752,
//        28,
//        878
//        ],
//        "backdrop_path":"\/iEQgMiqCIzS1osIuafgctvluGj5.jpg",
//        "adult":false,
//        "overview":"France, World War II, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their plane crashes during a mission consisting of destroying a German radio tower in Cielblanc, a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realize that, in addition to fighting Nazi troops that patrol the village, they also must fight against something else.",
//        "release_date":"2018-11-01"
//        },
//        {
//        "vote_count":469,
//        "id":166428,
//        "video":false,
//        "vote_average":8,
//        "title":"How to Train Your Dragon: The Hidden World",
//        "popularity":139.018,
//        "poster_path":"\/ij0xoc13hGhrYIlXGGuPXWTh3vi.jpg",
//        "original_language":"en",
//        "original_title":"How to Train Your Dragon: The Hidden World",
//        "genre_ids":[
//        16,
//        10751,
//        12
//        ],
//        "backdrop_path":"\/h3KN24PrOheHVYs9ypuOIdFBEpX.jpg",
//        "adult":false,
//        "overview":"As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away.  When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
//        "release_date":"2019-01-03"
//        },
//        {
//        "vote_count":604,
//        "id":375588,
//        "video":false,
//        "vote_average":5.7,
//        "title":"Robin Hood",
//        "popularity":124.055,
//        "poster_path":"\/AiRfixFcfTkNbn2A73qVJPlpkUo.jpg",
//        "original_language":"en",
//        "original_title":"Robin Hood",
//        "genre_ids":[
//        12,
//        28,
//        53
//        ],
//        "backdrop_path":"\/AuA50D7T7S7OEVcGo0ZKaMhERn0.jpg",
//        "adult":false,
//        "overview":"A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
//        "release_date":"2018-11-20"
//        },
//        {
//        "vote_count":3546,
//        "id":297802,
//        "video":false,
//        "vote_average":6.8,
//        "title":"Aquaman",
//        "popularity":115.538,
//        "poster_path":"\/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg",
//        "original_language":"en",
//        "original_title":"Aquaman",
//        "genre_ids":[
//        14,
//        12
//        ],
//        "backdrop_path":"\/5A2bMlLfJrAfX9bqAibOL2gCruF.jpg",
//        "adult":false,
//        "overview":"Once home to the most advanced civilization on Earth, the city of Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people -- and then the surface world. Standing in his way is Aquaman, Orm's half-human, half-Atlantean brother and true heir to the throne. With help from royal counselor Vulko, Aquaman must retrieve the legendary Trident of Atlan and embrace his destiny as protector of the deep.",
//        "release_date":"2018-12-07"
//        },
//        {
//        "vote_count":3561,
//        "id":332562,
//        "video":false,
//        "vote_average":7.4,
//        "title":"A Star Is Born",
//        "popularity":105.901,
//        "poster_path":"\/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg",
//        "original_language":"en",
//        "original_title":"A Star Is Born",
//        "genre_ids":[
//        18,
//        10402,
//        10749
//        ],
//        "backdrop_path":"\/wqtaHWOEZ3rXDJ8c6ZZShulbo18.jpg",
//        "adult":false,
//        "overview":"Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
//        "release_date":"2018-10-03"
//        },
//        {
//        "vote_count":192,
//        "id":522681,
//        "video":false,
//        "vote_average":6.1,
//        "title":"Escape Room",
//        "popularity":102.989,
//        "poster_path":"\/8yZAx7tlKRZIg7pJfaPhl00yHIQ.jpg",
//        "original_language":"en",
//        "original_title":"Escape Room",
//        "genre_ids":[
//        27,
//        53,
//        28
//        ],
//        "backdrop_path":"\/mWLljCmpqlcYQh7uh51BBMwCZwN.jpg",
//        "adult":false,
//        "overview":"Six strangers find themselves in circumstances beyond their control, and must use their wits to survive.",
//        "release_date":"2019-01-03"
//        },
//        {
//        "vote_count":79,
//        "id":280217,
//        "video":false,
//        "vote_average":6.9,
//        "title":"The Lego Movie 2: The Second Part",
//        "popularity":101.633,
//        "poster_path":"\/QTESAsBVZwjtGJNDP7utiGV37z.jpg",
//        "original_language":"en",
//        "original_title":"The Lego Movie 2: The Second Part",
//        "genre_ids":[
//        28,
//        12,
//        16,
//        35,
//        10751,
//        878,
//        14
//        ],
//        "backdrop_path":"\/aD5KKGUphqW5XN5InTSID3TUBnh.jpg",
//        "adult":false,
//        "overview":"It's been five years since everything was awesome and the citizens are facing a huge new threat: LEGO DUPLO® invaders from outer space, wrecking everything faster than they can rebuild.",
//        "release_date":"2019-01-26"
//        },
//        {
//        "vote_count":834,
//        "id":428078,
//        "video":false,
//        "vote_average":5.9,
//        "title":"Mortal Engines",
//        "popularity":100.022,
//        "poster_path":"\/uXJVpPXxZO4L8Rz3IG1Y8XvZJcg.jpg",
//        "original_language":"en",
//        "original_title":"Mortal Engines",
//        "genre_ids":[
//        878,
//        28,
//        12,
//        14,
//        53
//        ],
//        "backdrop_path":"\/rxYG6Sj95as9rv9wKIHUx6ATWd3.jpg",
//        "adult":false,
//        "overview":"Set in a world many thousands of years in the future. Earth’s cities now roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive Traction Cities, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the Outlands who will change the course of his life forever.",
//        "release_date":"2018-12-05"
//        },
//        {
//        "vote_count":11346,
//        "id":299536,
//        "video":false,
//        "vote_average":8.3,
//        "title":"Avengers: Infinity War",
//        "popularity":99.959,
//        "poster_path":"\/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
//        "original_language":"en",
//        "original_title":"Avengers: Infinity War",
//        "genre_ids":[
//        12,
//        28,
//        14
//        ],
//        "backdrop_path":"\/bOGkgRGdhrBYJSLpXaxhXVstddV.jpg",
//        "adult":false,
//        "overview":"As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
//        "release_date":"2018-04-25"
//        },
//        {
//        "vote_count":4835,
//        "id":335983,
//        "video":false,
//        "vote_average":6.6,
//        "title":"Venom",
//        "popularity":99.774,
//        "poster_path":"\/2uNW4WbgBXL25BAbXGLnLqX71Sw.jpg",
//        "original_language":"en",
//        "original_title":"Venom",
//        "genre_ids":[
//        878,
//        28
//        ],
//        "backdrop_path":"\/VuukZLgaCrho2Ar8Scl9HtV3yD.jpg",
//        "adult":false,
//        "overview":"Investigative journalist Eddie Brock attempts a comeback following a scandal, but accidentally becomes the host of Venom, a violent, super powerful alien symbiote. Soon, he must rely on his newfound powers to protect the world from a shadowy organization looking for a symbiote of their own.",
//        "release_date":"2018-09-28"
//        },
//        {
//        "vote_count":6,
//        "id":450001,
//        "video":false,
//        "vote_average":7.9,
//        "title":"Master Z: Ip Man Legacy",
//        "popularity":95.702,
//        "poster_path":"\/7Hy0qn054TBkapuCutQKeebaGJE.jpg",
//        "original_language":"cn",
//        "original_title":"葉問外傳：張天志",
//        "genre_ids":[
//        28
//        ],
//        "backdrop_path":"\/LvszV7H5pkRcTig5HcqQ5wEpcq.jpg",
//        "adult":false,
//        "overview":"After being defeated by Ip Man, Cheung Tin Chi (Zhang) is attempting to keep a low profile. While going about his business, he gets into a fight with a foreigner by the name of Davidson (Bautista), who is a big boss behind the bar district. Tin Chi fights hard with Wing Chun and earns respect.",
//        "release_date":"2018-12-20"
//        },
//        {
//        "vote_count":18,
//        "id":390634,
//        "video":false,
//        "vote_average":4.3,
//        "title":"Fate\/stay night: Heaven’s Feel II. lost butterfly",
//        "popularity":91.799,
//        "poster_path":"\/4tS0iyKQBDFqVpVcH21MSJwXZdq.jpg",
//        "original_language":"ja",
//        "original_title":"劇場版「Fate\/stay night [Heaven's Feel] ⅠⅠ. lost butterfly」",
//        "genre_ids":[
//        16,
//        28,
//        14,
//        12
//        ],
//        "backdrop_path":"\/3haESpzscyP1pLl2BxQ9j5KK9cM.jpg",
//        "adult":false,
//        "overview":"Theatrical-release adaptation of the visual novel \"Fate\/stay night\", following the third and final route. (Part 2 of a trilogy.)",
//        "release_date":"2019-01-12"
//        }
//        ]
//        }