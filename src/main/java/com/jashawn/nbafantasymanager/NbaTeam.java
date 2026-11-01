package com.jashawn.nbafantasymanager;

import java.util.HashMap;
import java.util.Map;

public enum NbaTeam {
    BOSTON_CELTICS("Boston", "BOS", "Boston Celtics", "Atlantic"),
    BROOKLYN_NETS("Brooklyn", "BKN", "Brooklyn Nets", "Atlantic"),
    NEW_YORK_KNICKS("New York", "NYK", "New York Knicks", "Atlantic"),
    PHILADELPHIA_76ERS("Philadelphia", "PHI", "Philadelphia 76ers", "Atlantic"),
    TORONTO_RAPTORS("Toronto", "TOR", "Toronto Raptors", "Atlantic"),
    CHICAGO_BULLS("Chicago", "CHI", "Chicago Bulls", "Central"),
    CLEVELAND_CAVALIERS("Cleveland", "CLE", "Cleveland Cavaliers", "Central"),
    DETROIT_PISTONS("Detroit", "DET", "Detroit Pistons", "Central"),
    INDIANA_PACERS("Indiana", "IND", "Indiana Pacers", "Central"),
    MILWAUKEE_BUCKS("Milwaukee", "MIL", "Milwaukee Bucks", "Central"),
    ATLANTA_HAWKS("Atlanta", "ATL", "Atlanta Haws", "Southeast"),
    CHARLOTTE_HORNETS("Charlotte", "CHA", "Charlotte Hornets", "Southeast"),
    MIAMI_HEAT("Miami", "MIA", "Miami Heat", "Southeast"),
    ORLANDO_MAGIC("Orlando", "ORL", "Orlando Magic", "Southeast"),
    WASHINGTON_WIZARDS("Washington", "WAS", "Washington Wizards", "Southeast"),
    DENVER_NUGGETS("Denver", "DEN", "Denver Nuggets", "Northwest"),
    MINNESOTA_TIMBERWOLVES("Minnesota", "MIN", "Minnesota Timberwolves", "Northwest"),
    OKLAHOMA_CITY_THUNDER("Oklahoma City", "OKC", "Oklahoma City Thunder", "Northwest"),
    PORTLAND_TRAILBLAZERS("Portland", "POR", "Portland Trailblazers", "Northwest"),
    UTAH_JAZZ("Utah", "UTA", "Utah Jazz", "Northwest"),
    GOLDEN_STATE_WARRIORS("San Francisco", "GSW", "Golden State Warriors", "Pacific"),
    LOS_ANGELES_CLIPPERS("Los Angeles", "LAC", "Los Angeles Clippers", "Pacific"),
    LOS_ANGELES_LAKERS("Los Angeles", "LAL", "Los Angeles Lakers", "Pacific"),
    PHOENIX_SUNS("Phoenix", "PHX", "Phoenix Suns", "Pacific"),
    SACRAMENTO_KINGS("Sacramento", "SAC", "Sacramento Kings", "Pacific"),
    DALLAS_MAVERICKS("Dallas", "DAL", "Dallas Mavericks", "Southwest"),
    HOUSTON_ROCKETS("Houston", "HOU", "Houston Rockets", "Southwest"),
    MEMPHIS_GRIZZLIES("Memphis", "MEM", "Memphis Grizzlies", "Southwest"),
    NEW_ORLEANS_PELICANS("New Orleans", "NOP", "New Orleans Pelicans", "Southwest"),
    SAN_ANTONIO_SPURS("San Antonio", "SAS", "San Antonio Spurs", "Southwest");

    private final String city;
    private final String abbreviation;
    private final String fullTeamName;
    private final String division;

    /**
     * Creates a hash map for searching for teams in O(1) rather than looping O(n).
     * Static initialization block is ran after memory allocation and enum instantiation.
     */
    private static final Map<String, NbaTeam> BY_ABBREVIATION = new HashMap<>();
//    Static initialization block below
    static {
        for (NbaTeam team : values()) {
            BY_ABBREVIATION.put(team.getAbbreviation().toUpperCase(), team);
        }
    }

    private NbaTeam(String city, String abbreviation, String fullTeamName, String division) {
        this.city = city;
        this.abbreviation = abbreviation;
        this.fullTeamName = fullTeamName;
        this.division = division;
    }

    public String getCity() {return city;}
    public String getAbbreviation() {return abbreviation;}
    public String getFullTeamName() {return fullTeamName;}
    public String getDivision() {return division;}

    /**
     * Finds an NBA team by its abbreviation (e.g., "LAL" -> LOS_ANGELES_LAKERS).
     * @return NbaTeam enum or null if not found
     */
    public static NbaTeam fromAbbreviation(String abbreviation) {
        if (abbreviation == null) return null;
        return BY_ABBREVIATION.get(abbreviation.toUpperCase());
    }
}
