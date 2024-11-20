package ui;
import dto.DvD;
import java.util.List;

public class DvDLibraryView {

    UserIO io = new UserIOConsoleImpl();

    public int PrintMenuGetSelection(){

       io.print("1. Add DVD");
       io.print("2. Remove DVD");
       io.print("3. Edit DVD");
       io.print("4. List All DVD's");
       io.print("5. Search DVD");
       io.print("6. Exit");
            return io.readInt("Please enter a number from the above choices.", 1,6);
    }
    public DvD getNewDvDInfo(){
        String title = io.readString("What is the movie title?");
        String releaseDate = io.readString("What was the release date?");
        String rating = io.readString("What is the official rating?");
        String directorName = io.readString("What is the directors name?");
        String studio = io.readString("What was the name of the studio that produced the DVD?");
        String personalRating = io.readString("What is your personal rating of the DVD?");
        DvD currentDVD = new DvD(title);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setDirectorName(directorName);
        currentDVD.setPersonalRating(personalRating);
        currentDVD.setStudio(studio);
        currentDVD.setRating(rating);
        return currentDVD;
    }
    public void displayAddDVD(){
        io.print("=== Create DVD ===");
    }
    public void displayCompletedAddiction(){
        io.readString("DVD added successfully, hit enter to continue.");
    }
    public void getAllDvDs(List<DvD> dvdList){
        for(DvD currentDvD: dvdList){
            io.print("Title: " + currentDvD.getTitle() + "| Release Date: " + currentDvD.getReleaseDate()
                    + "| Official Rating: " + currentDvD.getRating() + "| Directors Name: " + currentDvD.getDirectorName()
                    + "| Studio: " + currentDvD.getStudio() + "| Personal Rating: " + currentDvD.getPersonalRating());

        }
        io.readString("Please Hit Enter To Continue");
    }
    public String askForTitle(){
        return io.readString("Please Enter The DvD Title");
    }
    public void getDvD(DvD currentDvD) {
        if (currentDvD != null) {
            io.print("Title: " + currentDvD.getTitle() + "| Release Date: " + currentDvD.getReleaseDate()
                    + "| Official Rating: " + currentDvD.getRating() + "| Directors Name: " + currentDvD.getDirectorName()
                    + "| Studio: " + currentDvD.getStudio() + "| Personal Rating: " + currentDvD.getPersonalRating());
        }else{
            io.print("DvD was not found.");
        }
        io.readString("Please hit enter to continue.");
    }
    public void displayRemoveDvD(){
        io.print("=== Remove DVD ===");
    }
    public void displayRemovedDvD(){
        io.readString("DvD removed successfully, please hit enter to continue.");
    }
    public int printeEditMenu(){
        io.print("1. Edit Title");
        io.print("2. Edit Release Date");
        io.print("3. Edit Official Rating");
        io.print("4. Edit Director Name");
        io.print("5. Edit Studio");
        io.print("6. Edit Personal Rating");
        io.print("7. Back");
        return io.readInt("Please enter a number from the above choices.", 1,7);

    }

    public DvD editDvD(DvD pickedDvD, int choice) {
        DvD dvd = pickedDvD;

            if(choice == 1){
                io.print("Current Title: " + dvd.getTitle());
                dvd.setTitle(io.readString("What is the new title?"));
                io.print("New Title: " + dvd.getTitle());
                io.readString("Please hit enter to continue.");
            }else if(choice == 2){
                io.print("Current Release Date : " + dvd.getReleaseDate());
                dvd.setReleaseDate(io.readString("What is the new release Date?"));
                io.print("New Title: " + dvd.getReleaseDate());
                io.readString("Please hit enter to continue.");
            }else if(choice == 3){
                io.print("Current Rating: " + dvd.getRating());
                dvd.setRating(io.readString("What is the new Rating?"));
                io.print("New Title: " + dvd.getRating());
                io.readString("Please hit enter to continue.");
            }else if(choice == 4){
                io.print("Current Director Name: " + dvd.getDirectorName());
                dvd.setDirectorName(io.readString("What is the new Director Name"));
                io.print("New Director Name: " + dvd.getDirectorName());
                io.readString("Please hit enter to continue.");
            }else if(choice == 5){
                io.print("Current Studio: " + dvd.getStudio());
                dvd.setStudio(io.readString("What is the new Studio?"));
                io.print("New Studio: " + dvd.getStudio());
                io.readString("Please hit enter to continue.");
            }else if(choice == 6){
                io.print("Current Personal Rating: " + dvd.getPersonalRating());
                dvd.setPersonalRating(io.readString("What is the new Personal Rating?"));
                io.print("New Personal Rating: " + dvd.getPersonalRating());
                io.readString("Please hit enter to continue.");
            }else if (choice == 7){
                io.readString("Hit Enter To Continue");
            }
            return dvd;
    }

    public void titleNotFound(){
            io.print("Title was not found please enter a valid title.");
    }
}
