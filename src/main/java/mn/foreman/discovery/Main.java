package mn.foreman.discovery;

import mn.foreman.io.ApiRequest;
import mn.foreman.io.ApiRequestImpl;
import mn.foreman.io.Connection;
import mn.foreman.io.ConnectionFactory;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * This application will query a cgminer at the desired IP and port and dump
 * "stats" and "pools" responses to a local file.
 */
public class Main {

    /**
     * The application entry point.
     *
     * @param args The command line arguments.
     *
     * @throws IOException on failure to write an output file.
     */
    public static void main(final String[] args)
            throws IOException {
        final Scanner scanner = new Scanner(System.in);

        System.out.print("Enter API IP: ");
        final String apiIp = scanner.nextLine();

        System.out.print("Enter API Port: ");
        final int apiPort = scanner.nextInt();

        requestAndWrite(
                apiIp,
                apiPort,
                "summary");
        requestAndWrite(
                apiIp,
                apiPort,
                "stats");
        requestAndWrite(
                apiIp,
                apiPort,
                "devs");
        requestAndWrite(
                apiIp,
                apiPort,
                "pools");

        System.out.println(
                "DONE! - make sure you remove your wallet from pools.json");
    }

    /**
     * Queries the miner and writes the responses to a local file.
     *
     * @param apiIp   The API IP.
     * @param apiPort The API port.
     * @param command The command.
     *
     * @throws IOException on failure to open the output file.
     */
    private static void requestAndWrite(
            final String apiIp,
            final int apiPort,
            final String command) throws IOException {
        final ApiRequest request =
                new ApiRequestImpl(
                        apiIp,
                        apiPort,
                        String.format(
                                "{\"command\":\"%s\"}",
                                command));
        final Connection connection =
                ConnectionFactory.createJsonConnection(
                        request);
        connection.query();

        if (request.waitForCompletion(
                10,
                TimeUnit.SECONDS)) {
            final String response = request.getResponse();
            FileUtils.writeByteArrayToFile(
                    new File(command + ".json"),
                    response.getBytes());
            System.out.println(
                    "Captured '" + command + "' response to '" +
                            command + ".json'...");
        } else {
            System.out.println("Failed to connect to " + apiIp + ":" + apiPort);
        }
    }
}