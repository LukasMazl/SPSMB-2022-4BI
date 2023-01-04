package cz.spsmb;

import cz.spsmb.model.UserEntity;
import cz.spsmb.repository.FileUserRepository;
import cz.spsmb.repository.UserRepository;

public class Application {

    public static void main(String[] args) {
        UserRepository userRepository = new FileUserRepository("C:\\Users\\mazl\\IdeaProjects\\SPSMB-2022-4BI-2\\Lessons\\Later\\student.csv");
        System.out.println(userRepository.getAll());
    }
}
