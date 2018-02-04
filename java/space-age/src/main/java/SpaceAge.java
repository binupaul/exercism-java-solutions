class SpaceAge {
    
    private double earthYears;
    private double seconds;
    private static final double EARTH_SECONDS = 31557600;
    
    SpaceAge(double seconds) {
        this.seconds = seconds;
        earthYears = seconds/EARTH_SECONDS;
    }

    double getSeconds() {
        return seconds;
    }

    double onEarth() {
        return earthYears;
    }

    double onMercury() {
        return earthYears/Planet.MERCURY.period;
    }

    double onVenus() {
        return earthYears/Planet.VENUS.period;
    }

    double onMars() {
        return earthYears/Planet.MARS.period;
    }

    double onJupiter() {
        return earthYears/Planet.JUPITER.period;
    }

    double onSaturn() {
        return earthYears/Planet.SATURN.period;
    }

    double onUranus() {
        return earthYears/Planet.URANUS.period;
    }

    double onNeptune() {
       return earthYears/Planet.NEPTUNE.period;
    }

    private enum Planet {
        MERCURY (0.2408467),
        VENUS   (0.61519726),
        EARTH   (1.0),
        MARS    (1.8808158),
        JUPITER (11.862615),
        SATURN  (29.447498),
        URANUS  (84.016846),
        NEPTUNE (164.79132);
        
        private double period;
        Planet(double period) {
            this.period = period;
        }
    }
}

