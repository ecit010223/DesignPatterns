package com.year2018.effective_java.item01;

/**
 * Author: zyh
 * Date: 2018/10/18 13:20
 */
public class Test {
    public static void main(String[] args) {
        // Providers would execute these lines
        Services.registerDefaultProvider(DEFAULT_PROVIDER);
        Services.registerProvider("comp", COMP_PROVIDER);
        Services.registerProvider("armed", ARMED_PROVIDER);

        // Clients would execute these lines
        Service s1 = Services.newInstance();
        Service s2 = Services.newInstance("comp");
        Service s3 = Services.newInstance("armed");
        System.out.printf("%s, %s, %s%n", s1, s2, s3);
    }

    private static Provider DEFAULT_PROVIDER = new Provider() {
        public Service newService() {
            return new Service() {
                @Override
                public String toString() {
                    return "Default service";
                }
            };
        }
    };

    private static Provider COMP_PROVIDER = new Provider() {
        public Service newService() {
            return new Service() {
                @Override
                public String toString() {
                    return "Complementary service";
                }
            };
        }
    };

    private static Provider ARMED_PROVIDER = new Provider() {
        public Service newService() {
            return new Service() {
                @Override
                public String toString() {
                    return "Armed service";
                }
            };
        }
    };
}
