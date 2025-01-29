package ru.job4j.solid.dip;

class DataManager {
    private MySqlDatabase database = new MySqlDatabase();

    public void save(String data) {
        database.saveData(data);
    }
}
