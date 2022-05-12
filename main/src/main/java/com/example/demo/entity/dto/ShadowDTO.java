package com.example.demo.entity.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ShadowDTO implements Serializable {

    private static final long serialVersionUID = 1L;



    /**
     * state : {"desired":{"color":"RED","sequence":["RED","GREEN","BLUE"]},"reported":{"color":"GREEN"}}
     * metadata : {"desired":{"color":{"timestamp":1469564492},"sequence":{"timestamp":1469564492}},"reported":{"color":{"timestamp":1469564492}}}
     * timestamp : 1469564492
     * version : 1
     */

    private StateBean state;
    private MetadataBean metadata;
    private Date timestamp;
    private String version;

    @Data
    public static class StateBean implements Serializable {
        /**
         * desired : {"color":"RED","sequence":["RED","GREEN","BLUE"]}
         * reported : {"color":"GREEN"}
         */
        private static final long serialVersionUID = 1L;
        private DesiredBean desired;
        private ReportedBean reported;

        @Data
        public static class DesiredBean implements Serializable {
            /**
             * color : RED
             * sequence : ["RED","GREEN","BLUE"]
             */
            private static final long serialVersionUID = 1L;
            private String color;
            private List<String> sequence;
        }

        @Data
        public static class ReportedBean implements Serializable {
            /**
             * color : GREEN
             */
            private static final long serialVersionUID = 1L;
            private String color;
        }
    }

    @Data
    public static class MetadataBean implements Serializable {
        /**
         * desired : {"color":{"timestamp":1469564492},"sequence":{"timestamp":1469564492}}
         * reported : {"color":{"timestamp":1469564492}}
         */
        private static final long serialVersionUID = 1L;
        private DesiredBeanX desired;
        private ReportedBeanX reported;

        @Data
        public static class DesiredBeanX implements Serializable {
            /**
             * color : {"timestamp":1469564492}
             * sequence : {"timestamp":1469564492}
             */
            private static final long serialVersionUID = 1L;
            private ColorBean color;
            private SequenceBean sequence;

            @Data
            public static class ColorBean implements Serializable {
                /**
                 * timestamp : 1469564492
                 */
                private static final long serialVersionUID = 1L;
                private int timestamp;
            }

            @Data
            public static class SequenceBean implements Serializable {
                /**
                 * timestamp : 1469564492
                 */
                private static final long serialVersionUID = 1L;
                private int timestamp;
            }
        }

        @Data
        public static class ReportedBeanX implements Serializable {
            /**
             * color : {"timestamp":1469564492}
             */
            private static final long serialVersionUID = 1L;
            private ColorBeanX color;

            @Data
            public static class ColorBeanX implements Serializable {
                /**
                 * timestamp : 1469564492
                 */
                private static final long serialVersionUID = 1L;
                private int timestamp;
            }
        }
    }
}
