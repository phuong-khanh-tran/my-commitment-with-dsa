class SongNode {
    String title;
    SongNode next;

    SongNode(String title) {
        this.title = title;
        this.next = null;
    }
}

class Playlist {
    SongNode tail;
    SongNode current;

    void addSong(String title) {
        SongNode newNode = new SongNode(title);

        if (tail == null) {
            tail = newNode;
            newNode.next = tail;
            current = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
    }

    void playCurrent() {
        if (current == null) {
            System.out.println("Playlist is empty");
        } else {
            System.out.println("Now playing: " + current.title);
        }
    }

    void nextSong() {
        if (current != null) {
            current = current.next;
        }
    }

}

class Main {
    public static void main(String[] str) {
        Playlist myPlaylist = new Playlist();
        myPlaylist.addSong("Perfect");
        myPlaylist.addSong("Someone you loved");
        myPlaylist.addSong("sprited aray");

        for (int i = 0; i < 5; i++) {
            myPlaylist.playCurrent();
            myPlaylist.nextSong();
        }
    }
}
