package ru.job4j.solid.lsp;

public class ThrowFileReader extends FileReader {
    @Override
    public String readFile(String fileName) {
        if (!fileName.endsWith(".secure")) {
            throw new SecurityException("Access denied to file: " + fileName);
        }
        return super.readFile(fileName);
    }
}
