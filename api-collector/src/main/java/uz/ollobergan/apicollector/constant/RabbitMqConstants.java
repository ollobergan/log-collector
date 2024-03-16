package uz.ollobergan.apicollector.constant;

public class RabbitMqConstants {
    //------------------------------------------------------------------------------------------------------------------
    // QUEUES
    //------------------------------------------------------------------------------------------------------------------
    public static final String RABBIT_MAIN_QUEUE = "log_collector_queue";
    public static final String RABBIT_MAIN_QUEUE_ERROR = "log_collector_queue_error";

    //------------------------------------------------------------------------------------------------------------------
    // EXCHANGES
    //------------------------------------------------------------------------------------------------------------------
    public static final String RABBIT_MAIN_EXCHANGE = "log_collector_exchange";
    public static final String RABBIT_MAIN_EXCHANGE_ERROR = "log_collector_exchange_error";

    //------------------------------------------------------------------------------------------------------------------
    // ROUTING KEYS
    //------------------------------------------------------------------------------------------------------------------
    public static final String RABBIT_MAIN_ROUTING_KEY = "log_collector_routing_key";
    public static final String RABBIT_MAIN_ROUTING_KEY_ERROR = "log_collector_routing_key_error";

}
