package p08_petClinics.entity;

import p08_petClinics.until.Config;

import java.util.Arrays;
import java.util.Objects;

public class Clinic {

    private final String INVALID_NAME_EX_MESSAGE = "Invalid clinic name! Need be String containing of alphabetical characters with length [1-50]!";
    private final String INVALID_OPERATION_EX_MESSAGE = "Invalid Operation!";

    private String name;
    private Pet[] rooms;
    private final int startIndex;

    public Clinic(String name, int roomsCount) {
        this.setName(name);
        this.setRooms(roomsCount);
        this.startIndex = this.rooms.length / 2;
    }

    private void setName(String name) {
        if (name.length() > 50 || !name.matches("[A-Za-z]+")){
            throw new IllegalArgumentException(INVALID_NAME_EX_MESSAGE);
        }
        this.name = name;
    }

    private void setRooms(int roomsCount) {
        /**Clinic rooms need to be odd number*/
        if (roomsCount % 2 == 0 || roomsCount < 1 || roomsCount > 101) {
            throw new IllegalArgumentException(INVALID_OPERATION_EX_MESSAGE);
        }
        this.rooms = new Pet[roomsCount];
    }

    public String getName() {
        return this.name;
    }

    public Pet getRoomByIndex(int roomIndex) {
        return (roomIndex >= 0 && roomIndex < this.rooms.length) ? this.rooms[roomIndex] : null;
    }

    public boolean addPet(Pet pet) {
        /**No need to try add pet in room if there are not empty rooms*/
        if (!this.hasEmptyRoom()) {
            return false;
        }

        int currentIndex = this.startIndex;
        int step = 1;
        boolean onLeft = true;

        while (this.hasNext(currentIndex)) {
            /**If the room is empty -> pet can enter in the room and return true*/
            if (this.rooms[currentIndex] == null) {
                this.rooms[currentIndex] = pet;
                return true;
            }
            /**If onLeft = true -> currentIndex = startIndex - step
             * else -> currentIndex = startIndex + step, step++ */
            currentIndex = onLeft ? (this.startIndex - step) : this.startIndex + step++;
            onLeft = !onLeft;
        }

        /**If no one room is empty -> Pet don't enter nowhere and return false.*/
        return false;
    }

    private boolean hasNext(int currentIndex) {
        return (currentIndex >= 0 && currentIndex < this.rooms.length);
    }

    public boolean hasEmptyRoom() {
        return Arrays.stream(this.rooms).anyMatch(Objects::isNull);
    }

    public boolean release() {
        //Strange but this solution don't work (60/100 in Judge). For Debug and fixing the problem!!!
//        boolean isReleased = executeRelease(this.startIndex, this.rooms.length);
//        if (isReleased) {
//            return true;
//        }
//        return executeRelease(0, this.startIndex);

        for (int i = this.startIndex; i < this.rooms.length; i++) {
            if (this.rooms[i] != null) {
                this.rooms[i] = null;
                return true;
            }
        }
        for (int i = 0; i < this.startIndex; i++) {
            if (this.rooms[i] != null) {
                this.rooms[i] = null;
                return true;
            }
        }
        return false;
    }

    private boolean executeRelease(int startIndex, int end) {
        boolean isReleased = false;
        for (int i = startIndex; i < end; i++) {
            if (this.rooms[i] != null) {
                this.rooms[i] = null;
                isReleased = true;
            }
        }
        return isReleased;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.rooms.length; i++) {
            if (this.rooms[i] == null) {
                sb.append(Config.EMPTY_ROOM);
            } else {
                sb.append(this.rooms[i].toString());
            }
            if (i < this.rooms.length - 1) {
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

//    private final class ClinicIterator implements Iterator<Pet> {
//
//        private final int STARTING_STEP = 1;
//
//        private int currentIndex;
//        private int startIndex;
//        private int step;
//        private boolean onLeft;
//
//        public ClinicIterator() {
//            this.startIndex = rooms.length / 2;
//            this.currentIndex = startIndex;
//            this.step = STARTING_STEP;
//            this.onLeft = true;
//        }
//
//        @Override
//        public boolean hasNext() {
//            return this.currentIndex >= 0
//                    && this.currentIndex < rooms.length;
//        }
//
//        @Override
//        public Pet next() {
//            Pet pet = rooms[currentIndex];
//
//            if (this.onLeft) {
//                this.currentIndex = this.startIndex - this.step;
//            } else {
//                this.currentIndex = this.startIndex + this.step;
//                this.step++;
//            }
//            this.onLeft = !this.onLeft;
//
//            return pet;
//        }
//    }
}
