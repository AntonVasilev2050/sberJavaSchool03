package theme15gof1gof2;

enum SmartOrientation {

    NORTH {
        public SmartOrientation turn() {
            return EAST;
        }

        public Position move(Position position) {
            return position.changeY(1);
        }
    },
    WEST {
        public SmartOrientation turn() {
            return NORTH;
        }

        public Position move(Position position) {
            return position.changeX(-1);
        }
    },
    SOUTH {
        public SmartOrientation turn() {
            return WEST;
        }

        public Position move(Position position) {
            return position.changeY(-1);
        }
    },
    EAST {
        public SmartOrientation turn() {
            return SOUTH;
        }

        public Position move(Position position) {
            return position.changeX(1);
        }
    }

}
