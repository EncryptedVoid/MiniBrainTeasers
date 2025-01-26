use std::collections::HashMap;

fn main() {
    // Create a new HashMap
    let mut map = HashMap::new();

    // Insert key-value pairs
    map.insert("key1", "value1");
    map.insert("key2", "value2");

    // Get a value
    match map.get("key1") {
        Some(value) => println!("Value for key1: {}", value),
        None => println!("Key not found"),
    }

    // Update a value
    map.entry("key1").and_modify(|value| *value = "new_value");

    // Insert if key doesn't exist
    map.entry("key3").or_insert("value3");

    // Remove a key-value pair
    map.remove("key2");

    // Check if key exists
    if map.contains_key("key1") {
        println!("key1 exists");
    }

    // Iterate over key-value pairs
    for (key, value) in &map {
        println!("{}: {}", key, value);
    }

    // Get length of map
    println!("Map size: {}", map.len());

    // Clear the map
    map.clear();

    // Advanced usage: custom types as keys
    #[derive(Hash, Eq, PartialEq)]
    struct CustomKey {
        id: u32,
        name: String,
    }

    let mut custom_map = HashMap::new();
    let key = CustomKey {
        id: 1,
        name: String::from("test"),
    };

    custom_map.insert(key, "custom value");
}