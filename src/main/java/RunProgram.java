/**
 * @author Dylan Thomas - djthomas4
 * CIS175 - Fall 2021
 * Sep 16, 2021
 */

import java.util.List;
import java.util.Scanner;

import controller.WeaponHelper;
import model.Weapon;

public class RunProgram {

		static Scanner in = new Scanner(System.in);
		static WeaponHelper weph = new WeaponHelper();

		private static void addWeapon() {
			System.out.print("\nEnter the weapon name: ");
			String name = in.nextLine();
			System.out.print("Enter the weapon type: ");
			String weaponType = in.nextLine();
			
			Weapon toAdd = new Weapon(name, weaponType);
			weph.insertWeapon(toAdd);
		}

		private static void deleteWeapon() {
			System.out.print("\nEnter the weapon name to delete: ");
			String name = in.nextLine();
			System.out.print("Enter the weapon type to delete: ");
			String weaponType = in.nextLine();
			
			
			Weapon toDelete =	new	Weapon(name, weaponType);
			weph.deleteWeapon(toDelete);
		}

		private static void updateWeapon() {
			System.out.println("\nHow would you like to search? ");
			System.out.println("1: Search by Weapon name");
			System.out.println("2: Search by Weapon type");
			int searchBy = in.nextInt();
			in.nextLine();
			List<Weapon> found;
			if (searchBy == 1) {
				System.out.print("\nEnter the weapon name: ");
				String weaponName = in.nextLine();
				found = weph.searchForWeaponByWeaponName(weaponName);
				
			} else {
				System.out.print("\nEnter the weapon type: ");
				String weaponTypeName = in.nextLine();
				found = weph.searchForWeaponByWeaponType(weaponTypeName);
			}

			if (!found.isEmpty()) {
				System.out.println("\nSearch Results\n----------");
				for (Weapon l : found) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("\nWhich ID would you like to edit: ");
				int idToEdit = in.nextInt();

				Weapon toEdit = weph.searchForWeaponById(idToEdit);
				System.out.println("\nRetrieved " + toEdit.getWeaponType() + " named " + toEdit.getName());
				System.out.println("1 : Update Weapon name");
				System.out.println("2 : Update Weapon type");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("\nNew weapon name: ");
					String newWeaponName = in.nextLine();
					toEdit.setName(newWeaponName);
				} else if (update == 2) {
					System.out.print("\nNew weapon type: ");
					String newWeaponType = in.nextLine();
					toEdit.setWeaponType(newWeaponType);
				}

				weph.updateWeapon(toEdit);

			} else {
				System.out.println("\nWeapon not found");
			}

		}

		public static void main(String[] args) {
			runMenu();
		}

		public static void runMenu() {
			boolean restart = true;
			System.out.println("----- Gear Collection Tracker -----");
			while (restart) {
				System.out.println("\n     MENU\n---------------");
				System.out.println("  1. Add");
				System.out.println("  2. Delete");
				System.out.println("  3. Edit");
				System.out.println("  4. View collection");
				System.out.println("  5. Quit");
				System.out.print("  Enter a menu choice: ");
				int choice = in.nextInt();
				in.nextLine();

				if (choice == 1) {
					addWeapon();
				} else if (choice == 2) {
					deleteWeapon();
				} else if (choice == 3) {
					updateWeapon();
				} else if (choice == 4) {
					viewGearList();
				} else {
					weph.cleanUp();
					System.out.println("\nGoodbye.");
					restart = false;
				}

			}

		}

		private static void viewGearList() {
			List<Weapon> allWeapons = weph.showAllWeapons();
			System.out.println("");
			for(Weapon singleWeapon : allWeapons){
				System.out.println(singleWeapon.returnWeaponDetails());
			}

		}
		

	}
