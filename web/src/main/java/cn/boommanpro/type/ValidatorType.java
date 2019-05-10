package cn.boommanpro.type;

public enum ValidatorType {
    /**
     *
     */
    INT {
        @Override
        public String create() {
            return "";
        }
    },
    LOOKUPVALUE {
        @Override
        public String create() {
            return "";
        }
    },
    DATE {
        @Override
        public String create() {
            return "";
        }
    };

    public String create() {
        return null;
    }
}
